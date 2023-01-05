package com.rafaelnunes.deliverlanches.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rafaelnunes.deliverlanches.services.exceptions.BadRequestException;
import com.rafaelnunes.deliverlanches.services.exceptions.EnderecoApiNotFoundException;
import com.rafaelnunes.deliverlanches.services.exceptions.ResourceNotFoundException;
import com.rafaelnunes.deliverlanches.services.exceptions.UnauthorizedException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError erro = new ValidationError(Instant.now(), status.value(), "Válidação de campos", "Erro ao informar campos", request.getRequestURI());
		
		for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			erro.addError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(EnderecoApiNotFoundException.class)
	public ResponseEntity<StandardError> EnderecoApiNotFound(EnderecoApiNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError erro = new StandardError(Instant.now(), status.value(), "Erro ao consultar CEP.", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> BadRequest(BadRequestException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError erro = new StandardError(Instant.now(), status.value(), "Erro ao cancelar o pedido", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> BadRequest(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(Instant.now(), status.value(), "Pedido não localizado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<StandardError> unauthorized(UnauthorizedException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		StandardError erro = new StandardError(Instant.now(), status.value(), "Sem autorização", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
}
