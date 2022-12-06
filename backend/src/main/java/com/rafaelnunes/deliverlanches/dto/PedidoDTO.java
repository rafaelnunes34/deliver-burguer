package com.rafaelnunes.deliverlanches.dto;

import java.io.Serializable;
import java.time.Instant;

import com.rafaelnunes.deliverlanches.entities.Pedido;
import com.rafaelnunes.deliverlanches.projections.PedidoProjection;

public class PedidoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant data;
	private String status;
	private String formaPagamento;
	private String clienteNome;
	private String cidade;
	private String bairro;
	private String endereco;
	private Double total;
	
	public PedidoDTO() {
	}

	public PedidoDTO(Long id, Instant data, String status, String formaPagamento, String clienteNome, String cidade,
			String bairro, String endereco, Double total) {
		this.id = id;
		this.data = data;
		this.status = status;
		this.formaPagamento = formaPagamento;
		this.clienteNome = clienteNome;
		this.cidade = cidade;
		this.bairro = bairro;
		this.endereco = endereco;
		this.total = total;
	}
	
	public PedidoDTO(Pedido pedido) {
		id = pedido.getId();
		data = pedido.getDataPedido();
		status = pedido.getStatus().toString();
		formaPagamento = pedido.getFormaPagamento().toString();
		clienteNome = pedido.getCliente().getNome();
		cidade = pedido.getEndereco().getLocalidade();
		bairro = pedido.getEndereco().getBairro();
		if(pedido.getEndereco().getComplemento() != null) {
			endereco = pedido.getEndereco().getLogradouro() + " " + pedido.getEndereco().getNumero() + " " + pedido.getEndereco().getComplemento();
		}
		else {
			endereco = pedido.getEndereco().getLogradouro() + " " + pedido.getEndereco().getNumero();
		}
		
		total = pedido.getTotal();
	}
	
	public PedidoDTO(PedidoProjection pedido) {
		id = pedido.getId();
		data = pedido.getDataPedido();
		status = pedido.getStatus();
		formaPagamento = pedido.getFormaPagamento();
		clienteNome = pedido.getClienteNome();
		cidade = pedido.getCidade();
		bairro = pedido.getBairro();
		if(pedido.getEnderecoComplemento() != null) {
			endereco = pedido.getLogradouro() + ' ' + pedido.getEnderecoComplemento();
		}
		else {
			endereco = pedido.getLogradouro();
		}
		
		total = pedido.getTotal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
