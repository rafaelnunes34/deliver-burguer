package com.rafaelnunes.deliverlanches.dto;

import java.io.Serializable;

public class EnderecoViaCepDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cep;
	private String localidade;
	private String bairro;
	private String logradouro;
	
	public EnderecoViaCepDTO() {
	}

	public EnderecoViaCepDTO(String cep, String localidade, String bairro, String logradouro) {
		this.cep = cep.replace("-", "");
		this.localidade = localidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep.replace("-", "");
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
}
