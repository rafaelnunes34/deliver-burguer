package com.rafaelnunes.deliverlanches.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.rafaelnunes.deliverlanches.entities.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "O campo não pode ser vazio.")
	private String nome;
	
	@Size(min = 11, max = 11, message = "Erro ao digitar o número de telefone.")
	private String telefone;
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, String telefone) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		telefone = usuario.getTelefone();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
