package com.rafaelnunes.deliverlanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelnunes.deliverlanches.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	Endereco findByCep(String cep);
}
