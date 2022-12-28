package com.rafaelnunes.deliverlanches.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaelnunes.deliverlanches.entities.Categoria;
import com.rafaelnunes.deliverlanches.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("SELECT obj FROM Produto obj JOIN FETCH obj.categoria cat "
			+ "WHERE COALESCE(:categoria) IS NULL OR cat = :categoria")
	List<Produto> buscarProdutosPorCategoria(Categoria categoria);
	
}
