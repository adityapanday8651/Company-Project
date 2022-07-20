package com.kisanlink.service.exception;


import org.springframework.security.core.AuthenticationException;

public class InActiveSellerException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 450250059512724800L;

	public InActiveSellerException(String msg) {
		super(msg);
	}
	
	public InActiveSellerException(String msg,Throwable t) {
		super(msg,t);
	}
	
}