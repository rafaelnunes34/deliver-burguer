package com.rafaelnunes.deliverlanches.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.rafaelnunes.deliverlanches.dto.EnderecoDTO;

@Constraint(validatedBy = EnderecoInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface EnderecoInsertValid {
	String message() default "Validation error";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	Class<EnderecoDTO> value();

}
