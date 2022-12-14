package com.rafaelnunes.deliverlanches.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafaelnunes.deliverlanches.dto.UsuarioDTO;
import com.rafaelnunes.deliverlanches.dto.UsuarioInsertDTO;
import com.rafaelnunes.deliverlanches.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping(value = "/cliente")
	public ResponseEntity<UsuarioDTO> criarCliente(@Valid @RequestBody UsuarioInsertDTO dto) {
		UsuarioDTO usuarioDTO = service.criarCliente(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(usuarioDTO);
	}
}
