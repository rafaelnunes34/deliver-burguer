package com.rafaelnunes.deliverlanches.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelnunes.deliverlanches.dto.EnderecoViaCepDTO;
import com.rafaelnunes.deliverlanches.services.ApiViaCepService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	private ApiViaCepService apiViaCepService;
	
	@GetMapping(path = "/{cep}")
	public ResponseEntity<EnderecoViaCepDTO> buscarEnderecoApiViaCep(@PathVariable String cep) {
		EnderecoViaCepDTO enderecoViaCepDTO = apiViaCepService.buscarEnderecoCep(cep);
		return ResponseEntity.ok().body(enderecoViaCepDTO);
	}
}
