package com.rafaelnunes.deliverlanches.services;

import org.springframework.stereotype.Service;

import com.rafaelnunes.deliverlanches.dto.EnderecoViaCepDTO;

@Service
public interface ApiViaCepService {
	
	EnderecoViaCepDTO buscarEnderecoCep(String cep);

}
