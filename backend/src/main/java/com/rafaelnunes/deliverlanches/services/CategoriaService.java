package com.rafaelnunes.deliverlanches.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelnunes.deliverlanches.dto.CategoriaDTO;
import com.rafaelnunes.deliverlanches.entities.Categoria;
import com.rafaelnunes.deliverlanches.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoriaDTO> listarCategorias() {
		List<Categoria> list = repository.findAll(Sort.by("nome"));
		return list.stream().map(cat -> new CategoriaDTO(cat)).collect(Collectors.toList());
	}
}
