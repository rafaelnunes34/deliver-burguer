package com.rafaelnunes.deliverlanches.dto;

import java.io.Serializable;

public class CarrinhoProdutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ProdutoDTO produto;
	private Integer quantidade;
	
	public CarrinhoProdutoDTO() {
	}

	public CarrinhoProdutoDTO(ProdutoDTO produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
