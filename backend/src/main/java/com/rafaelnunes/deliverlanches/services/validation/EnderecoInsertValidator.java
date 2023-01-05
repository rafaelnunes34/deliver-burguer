package com.rafaelnunes.deliverlanches.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rafaelnunes.deliverlanches.client.ApiViaCepClient;
import com.rafaelnunes.deliverlanches.dto.EnderecoDTO;
import com.rafaelnunes.deliverlanches.dto.EnderecoViaCepDTO;
import com.rafaelnunes.deliverlanches.resources.exceptions.FieldMessage;

public class EnderecoInsertValidator implements ConstraintValidator<EnderecoInsertValid, EnderecoDTO> {
	
	@Autowired
	private ApiViaCepClient apiViaCepClient;

	@Override
	public void initialize(EnderecoInsertValid ann) {
	}

	@Override
	public boolean isValid(EnderecoDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(dto == null) {
			list.add(new FieldMessage("Endereço", "O endereço deve ser informado."));
		}
		
		if(dto.getLocalidade() == null || dto.getLocalidade().equals("")) {
			list.add(new FieldMessage("Localidade", "A localidade deve ser informada."));
		}
		
		if(dto.getBairro() == null || dto.getBairro().equals("")) {
			list.add(new FieldMessage("Bairro", "O bairro deve ser informado."));
		}
		
		if(dto.getLogradouro() == null || dto.getLogradouro().equals("")) {
			list.add(new FieldMessage("Logradouro", "O logradouro deve ser informado."));
		}
		
		if(dto.getNumero() == null || dto.getNumero().equals("")) {
			list.add(new FieldMessage("Numero", "O numero do endereço deve ser informado."));
		}
		
		EnderecoViaCepDTO enderecoDTO = apiViaCepClient.buscarEndereco(dto.getCep());
		
		if(enderecoDTO == null) {
			list.add(new FieldMessage("Cep", "Cep informado e inválido."));
		}
		
		return list.isEmpty();
	}

}
