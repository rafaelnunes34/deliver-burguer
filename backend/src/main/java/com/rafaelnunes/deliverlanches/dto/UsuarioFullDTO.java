package com.rafaelnunes.deliverlanches.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UsuarioFullDTO extends UsuarioDTO	 {

	private static final long serialVersionUID = 1L;
	
	@Email(message = "Email inválido.")
	private String email;
	
	@Min(value = 6, message = "A senha tem que ter pelo menos 6 caracteres.")
	@NotBlank(message = "O campo não pode ser vazio.")
	private String senha;
	
	public UsuarioFullDTO() {
	}

	public UsuarioFullDTO(Long id, String nome, String telefone, String email, String senha) {
		super(id, nome, telefone);
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
