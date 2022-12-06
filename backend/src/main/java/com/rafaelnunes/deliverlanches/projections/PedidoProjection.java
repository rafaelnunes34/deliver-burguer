package com.rafaelnunes.deliverlanches.projections;

import java.time.Instant;

public interface PedidoProjection {
	
	Long getId();
	Instant getDataPedido();
	String getFormaPagamento();
	String getStatus();
	String getClienteNome();
	String getCidade();
	String getBairro();
	String getLogradouro();
	String getEnderecoComplemento();
	Double getTotal();
}	
