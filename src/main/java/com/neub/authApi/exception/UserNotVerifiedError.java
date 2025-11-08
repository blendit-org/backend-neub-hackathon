package com.neub.authApi.exception;

public class UserNotVerifiedError extends Exception {
	
	private String message;

	public UserNotVerifiedError(String message) {
		super(message);
	}
	
}
