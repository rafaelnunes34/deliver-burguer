package com.rafaelnunes.deliverlanches.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import com.rafaelnunes.deliverlanches.dto.EnderecoViaCepDTO;
import com.rafaelnunes.deliverlanches.services.exceptions.EnderecoApiNotFoundException;

import reactor.core.publisher.Mono;

@Service
public class ApiViaCepClient {

	private static Logger logger = LoggerFactory.getLogger(ApiViaCepClient.class);
	private final WebClient webClient;

	public ApiViaCepClient(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://viacep.com.br/ws").build();
	}

	public EnderecoViaCepDTO buscarEndereco(String cep) {
		try {
			Mono<EnderecoViaCepDTO> monoEndereco = this.webClient.method(HttpMethod.GET).uri("/{cep}/json/", cep)
					.retrieve().bodyToMono(EnderecoViaCepDTO.class);
			EnderecoViaCepDTO enderecoViaCep = monoEndereco.block();
			
			logger.info("Buscando endereco de cep " + cep);
			
			return enderecoViaCep;
		} 
		catch (WebClientException e) {
			logger.error("Erro ao buscar o cep -> " + cep);
			throw new EnderecoApiNotFoundException("Digite um cep válido " + cep);
		}
	}
}
