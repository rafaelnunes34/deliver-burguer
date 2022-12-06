package com.rafaelnunes.deliverlanches.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelnunes.deliverlanches.entities.Usuario;
import com.rafaelnunes.deliverlanches.repositories.UsuarioRepository;

@Service
public class AuthService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public Usuario retornaUsuarioAuthenticado() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return repository.findByEmail(username);
	}
}
