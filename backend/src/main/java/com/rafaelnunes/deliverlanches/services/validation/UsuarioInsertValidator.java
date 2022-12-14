package com.rafaelnunes.deliverlanches.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rafaelnunes.deliverlanches.dto.UsuarioInsertDTO;
import com.rafaelnunes.deliverlanches.entities.Usuario;
import com.rafaelnunes.deliverlanches.repositories.UsuarioRepository;
import com.rafaelnunes.deliverlanches.resources.exceptions.FieldMessage;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsertValid, UsuarioInsertDTO> {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void initialize(UsuarioInsertValid am) {
	}

	@Override
	public boolean isValid(UsuarioInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario usuario = repository.findByEmail(dto.getEmail());
		
		if(usuario != null) {
			list.add(new FieldMessage("Email", "Email já cadastrado"));
		}
		
		for(FieldMessage e: list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
						.addConstraintViolation();
		}
		
		return list.isEmpty();
	}

}
