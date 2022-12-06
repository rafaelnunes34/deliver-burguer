package com.rafaelnunes.deliverlanches.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.rafaelnunes.deliverlanches.dto.EnderecoViaCepDTO;
import com.rafaelnunes.deliverlanches.services.ApiViaCepService;
import com.rafaelnunes.deliverlanches.services.exceptions.EnderecoApiNotFoundException;

@Component
public class ApiViaCepServiceImpl implements ApiViaCepService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public EnderecoViaCepDTO buscarEnderecoCep(String cep) {
		try {
			String urlApi = "https://viacep.com.br/ws/" + cep + "/json/";
			ResponseEntity<EnderecoViaCepDTO> enderecoViaCepDTO = restTemplate.getForEntity(urlApi, EnderecoViaCepDTO.class);
			return enderecoViaCepDTO.getBody();
		}
		catch(HttpClientErrorException e) {
			throw new EnderecoApiNotFoundException("Não foi possivel localizar o CEP digitado...");
		}
	}

}
