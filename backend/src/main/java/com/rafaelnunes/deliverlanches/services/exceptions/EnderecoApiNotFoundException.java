package com.rafaelnunes.deliverlanches.services.exceptions;

public class EnderecoApiNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EnderecoApiNotFoundException(String msg) {
		super(msg);
	}
}
