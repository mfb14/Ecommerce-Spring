package com.project.ecommerce.exception;

public class CustomerIsNotExistException extends RuntimeException {

	public CustomerIsNotExistException(String message) {
		super(message);
	}
}
