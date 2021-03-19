package com.example.demo.Exception;

public class AccountExist extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountExist(String message) {
		super(message);
	}

}
