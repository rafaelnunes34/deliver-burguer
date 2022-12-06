package com.rafaelnunes.deliverlanches.dto;

import java.io.Serializable;

import com.rafaelnunes.deliverlanches.entities.Endereco;
import com.rafaelnunes.deliverlanches.services.validation.EnderecoInsertValid;

@EnderecoInsertValid(value = EnderecoDTO.class)
public class EnderecoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cep;
	private String localidade;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	
	public EnderecoDTO() {
	}

	public EnderecoDTO(Long id, String cep, String localidade, String bairro, String logradouro, String numero,
			String complemento) {
		this.id = id;
		this.cep = cep;
		this.localidade = localidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}
	
	public EnderecoDTO(Endereco endereco) {
		id = endereco.getId();
		cep = endereco.getCep();
		localidade = endereco.getLocalidade();
		bairro = endereco.getBairro();
		logradouro = endereco.getLogradouro();
		numero = endereco.getNumero();
		complemento = endereco.getComplemento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
