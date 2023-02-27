package com.nagarro.exception;

public class CommentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CommentNotFoundException() {
	}

	public CommentNotFoundException(String message) {
		super(message);
	}

	public CommentNotFoundException(Throwable cause) {
		super(cause);
	}

	public CommentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}


}
