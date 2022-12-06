package com.rafaelnunes.deliverlanches.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelnunes.deliverlanches.dto.EnderecoDTO;
import com.rafaelnunes.deliverlanches.entities.Endereco;
import com.rafaelnunes.deliverlanches.entities.Pedido;
import com.rafaelnunes.deliverlanches.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	@Transactional
	public Endereco salvarEndereco(EnderecoDTO dto, Pedido pedido) {
		Endereco endereco = new Endereco();
		endereco.setCep(dto.getCep());
		endereco.setLocalidade(dto.getLocalidade());
		endereco.setBairro(dto.getBairro());
		endereco.setLogradouro(dto.getLogradouro());
		endereco.setNumero(dto.getNumero());
		endereco.setComplemento(dto.getComplemento());
		endereco.setPedido(pedido);
		endereco = repository.save(endereco);
		return endereco;
	}
}
