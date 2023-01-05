package com.rafaelnunes.deliverlanches.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelnunes.deliverlanches.dto.CarrinhoProdutoDTO;
import com.rafaelnunes.deliverlanches.dto.CheckoutDTO;
import com.rafaelnunes.deliverlanches.dto.PedidoDTO;
import com.rafaelnunes.deliverlanches.entities.Endereco;
import com.rafaelnunes.deliverlanches.entities.Pedido;
import com.rafaelnunes.deliverlanches.entities.PedidoItem;
import com.rafaelnunes.deliverlanches.entities.Produto;
import com.rafaelnunes.deliverlanches.entities.Usuario;
import com.rafaelnunes.deliverlanches.entities.enums.FormaPagamento;
import com.rafaelnunes.deliverlanches.entities.enums.PedidoStatus;
import com.rafaelnunes.deliverlanches.projections.PedidoProjection;
import com.rafaelnunes.deliverlanches.repositories.PedidoItemRepository;
import com.rafaelnunes.deliverlanches.repositories.PedidoRepository;
import com.rafaelnunes.deliverlanches.repositories.ProdutoRepository;
import com.rafaelnunes.deliverlanches.services.exceptions.BadRequestException;
import com.rafaelnunes.deliverlanches.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Transactional(readOnly = true)
	public List<PedidoDTO> listarPedidos() {
		Usuario cliente = authService.retornaUsuarioAuthenticado();
		List<PedidoProjection> list = repository.listarPedidos(cliente.getId());
		return list.stream().map(pedidoProjection -> new PedidoDTO(pedidoProjection)).collect(Collectors.toList());
	} 
	
	@Transactional
	public PedidoDTO criarPedido(CheckoutDTO dto) {
		List<PedidoItem> listItem = new ArrayList<>();
		
		Usuario clienteLogado = authService.retornaUsuarioAuthenticado();
		
		Pedido pedido = new Pedido(null, Instant.now(), PedidoStatus.PENDENTE, FormaPagamento.valueOf(dto.getFormaPagamento()), clienteLogado, null);
		pedido = repository.saveAndFlush(pedido);
		
		Endereco endereco = enderecoService.salvarEndereco(dto.getEndereco(), pedido);
		pedido.setEndereco(endereco);
		
		for(CarrinhoProdutoDTO itemDto : dto.getItens()) {
			Produto produto = produtoRepository.getOne(itemDto.getProduto().getId());
			PedidoItem item = new PedidoItem(pedido, produto, itemDto.getQuantidade(), produto.getPreco());
			listItem.add(item);
		}
		
		pedidoItemRepository.saveAll(listItem);
		pedido.getItens().addAll(listItem);
		
		return new PedidoDTO(pedido);
	}
	
	
	@Transactional
	public PedidoDTO cancelarPedido(Long pedidoId) {
		try {
			Pedido pedido = repository.getOne(pedidoId);
			if( !pedido.getStatus().equals(PedidoStatus.PENDENTE) ) {
				 throw new BadRequestException("Não foi cancelar o pedido " + pedido.getId()); 
			}
			pedido.setStatus(PedidoStatus.CANCELADO);
			pedido = repository.save(pedido);
			return new PedidoDTO(pedido);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Não foi possivel localizar p pedido " + pedidoId);
		}
	}
	
	public List<FormaPagamento> listarFormaPagamento() {
		FormaPagamento[] list = FormaPagamento.values();
		return Arrays.asList(list);
	}
}
