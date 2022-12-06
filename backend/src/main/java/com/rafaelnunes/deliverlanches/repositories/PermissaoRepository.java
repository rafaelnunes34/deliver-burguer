package com.rafaelnunes.deliverlanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaelnunes.deliverlanches.entities.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
	@Query("SELECT obj FROM Permissao obj WHERE obj.id = 2")
	Permissao retornaAcessoCliente();
}
