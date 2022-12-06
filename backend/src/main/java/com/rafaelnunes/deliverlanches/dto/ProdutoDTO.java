package com.rafaelnunes.deliverlanches.dto;

import java.io.Serializable;

import com.rafaelnunes.deliverlanches.entities.Produto;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String descricao;
	private String imgUrl;
	private Double preco;
	
	public ProdutoDTO() {
	}

	public ProdutoDTO(Long id, String nome, String descricao, String imgUrl, Double preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imgUrl = imgUrl;
		this.preco = preco;
	}
	
	public ProdutoDTO(Produto prod) {
		id = prod.getId();
		nome = prod.getNome();
		descricao = prod.getDescricao();
		imgUrl = prod.getImgUrl();
		preco = prod.getPreco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
