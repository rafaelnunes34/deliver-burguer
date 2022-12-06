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

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError erro = new ValidationError();
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Erro ao informar campos");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			erro.addError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(EnderecoApiNotFoundException.class)
	public ResponseEntity<StandardError> EnderecoApiNotFound(EnderecoApiNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError erro = new StandardError();
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Erro ao localizar CEP.");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> BadRequest(BadRequestException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError erro = new StandardError();
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Erro ao cancelar o pedido");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> BadRequest(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError();
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Pedido não localizado");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
}
