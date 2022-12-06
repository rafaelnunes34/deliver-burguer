package com.rafaelnunes.deliverlanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelnunes.deliverlanches.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);
}
