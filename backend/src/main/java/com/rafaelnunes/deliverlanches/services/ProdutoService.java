package com.rafaelnunes.deliverlanches.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelnunes.deliverlanches.dto.ProdutoDTO;
import com.rafaelnunes.deliverlanches.entities.Categoria;
import com.rafaelnunes.deliverlanches.entities.Produto;
import com.rafaelnunes.deliverlanches.repositories.CategoriaRepository;
import com.rafaelnunes.deliverlanches.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional(readOnly = true)
	public List<ProdutoDTO> listarProdutos(Long categoriaId) {
		Categoria categoria = (categoriaId == 0) ? null : categoriaRepository.getOne(categoriaId);
		List<Produto> list = repository.buscarProdutosPorCategoria(categoria);
		return list.stream().map(prod -> new ProdutoDTO(prod)).collect(Collectors.toList());
	}
}
