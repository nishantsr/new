package com.cybage.exception;

public class UserNotFound extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1172075230153767617L;

	public UserNotFound(String msg) {
		super(msg);
	}
}
