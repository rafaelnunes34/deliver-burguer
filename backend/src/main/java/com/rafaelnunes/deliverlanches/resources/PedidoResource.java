package com.rafaelnunes.deliverlanches.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafaelnunes.deliverlanches.dto.CheckoutDTO;
import com.rafaelnunes.deliverlanches.dto.PedidoDTO;
import com.rafaelnunes.deliverlanches.entities.enums.FormaPagamento;
import com.rafaelnunes.deliverlanches.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<PedidoDTO>> listarPedidos() {
		List<PedidoDTO> list = service.listarPedidos();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<PedidoDTO> criarPedido(@Valid @RequestBody CheckoutDTO dto) {
		PedidoDTO pedido = service.criarPedido(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(pedido);		
	}
	
	@PutMapping(value = "/{pedidoId}/cancelarPedido")
	public ResponseEntity<PedidoDTO> cancelarPedido(@PathVariable Long pedidoId) {
		PedidoDTO dto = service.cancelarPedido(pedidoId);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/formaPagamento")
	public ResponseEntity<List<FormaPagamento>> listarFormaPagamento() {
		List<FormaPagamento> list = service.listarFormaPagamento();
		return ResponseEntity.ok().body(list);
	}
}
