package com.rafaelnunes.deliverlanches.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelnunes.deliverlanches.dto.ProdutoDTO;
import com.rafaelnunes.deliverlanches.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> listarProdutos(@RequestParam(name = "categoriaId", defaultValue = "0") Long categoriaId) {
		List<ProdutoDTO> list = service.listarProdutos(categoriaId);
		return ResponseEntity.ok().body(list);
	}
}
