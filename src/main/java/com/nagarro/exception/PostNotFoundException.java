package com.nagarro.exception;

public class PostNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PostNotFoundException() {
	}

	public PostNotFoundException(String message) {
		super(message);
	}

	public PostNotFoundException(Throwable cause) {
		super(cause);
	}

	public PostNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
