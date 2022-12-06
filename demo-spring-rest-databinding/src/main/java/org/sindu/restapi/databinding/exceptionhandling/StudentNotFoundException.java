package org.sindu.restapi.databinding.exceptionhandling;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String message) {
		super(message);
	}

}
