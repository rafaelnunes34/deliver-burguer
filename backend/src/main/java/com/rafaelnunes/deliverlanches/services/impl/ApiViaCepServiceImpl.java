package com.rafaelnunes.deliverlanches.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger logger = LoggerFactory.getLogger(ApiViaCepServiceImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public EnderecoViaCepDTO buscarEnderecoCep(String cep) {
		try {
			String urlApi = "https://viacep.com.br/ws/" + cep + "/json/";
			ResponseEntity<EnderecoViaCepDTO> enderecoViaCepDTO = restTemplate.getForEntity(urlApi, EnderecoViaCepDTO.class);
			
			logger.info("CEP consultado com sucesso. " + enderecoViaCepDTO.getStatusCode().toString());			
			return enderecoViaCepDTO.getBody();
		}
		catch(HttpClientErrorException e) {
			logger.error("Erro ao consultar cep " + cep);
			throw new EnderecoApiNotFoundException("Não foi possivel localizar o CEP digitado...");
		}
	}

}
