package com.project.ecommerce.exception;


public class CustomerIsNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerIsNotExistException(String message) {
		super(message);
	}
}
