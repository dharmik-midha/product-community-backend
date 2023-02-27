package com.nagarro.exception;

public class UserUnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserUnauthorizedException() {
	}

	public UserUnauthorizedException(String message) {
		super(message);
	}

	public UserUnauthorizedException(Throwable cause) {
		super(cause);
	}

	public UserUnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

}
