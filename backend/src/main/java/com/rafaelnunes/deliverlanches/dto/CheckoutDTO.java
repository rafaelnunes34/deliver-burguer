package com.rafaelnunes.deliverlanches.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CheckoutDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Informe a forma de pagamento")
	private String formaPagamento;
	
	@NotNull(message = "O campo endereco deve ser informado")
	@Valid
	private EnderecoDTO endereco;
	
	@NotEmpty(message = "O carrinho não pode está vazio")
	private List<CarrinhoProdutoDTO> itens = new ArrayList<>();
	
	public CheckoutDTO() {
	}
	
	public CheckoutDTO(String formaPagamento, EnderecoDTO endereco) {
		this.formaPagamento = formaPagamento;
		this.endereco = endereco;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public List<CarrinhoProdutoDTO> getItens() {
		return itens;
	}
}
