package com.rafaelnunes.deliverlanches.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelnunes.deliverlanches.dto.CategoriaDTO;
import com.rafaelnunes.deliverlanches.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
		List<CategoriaDTO> list = service.listarCategorias();
		return ResponseEntity.ok().body(list);
	}
}
