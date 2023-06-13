package com.thiagoferraz.mychess.exceptions;

public class MoveNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MoveNotAllowedException(String message) {
		super(message);
	}
	
	public MoveNotAllowedException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
