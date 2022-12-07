package org.sindu.restapi.restexceptionhandler;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message) {
		super(message);
	}

	
}
