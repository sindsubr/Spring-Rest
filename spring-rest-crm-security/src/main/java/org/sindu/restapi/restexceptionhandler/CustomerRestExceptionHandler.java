package org.sindu.restapi.restexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handle500Exception(CustomerNotFoundException exc) {
		CustomerResponseEntity customerResponseEntity = new CustomerResponseEntity();
		customerResponseEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
		customerResponseEntity.setMessage(exc.getMessage());
		customerResponseEntity.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(customerResponseEntity,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handleException(Exception exc) {
		CustomerResponseEntity customerResponseEntity = new CustomerResponseEntity();
		customerResponseEntity.setStatusCode(HttpStatus.BAD_REQUEST.value());
		customerResponseEntity.setMessage(exc.getMessage());
		customerResponseEntity.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(customerResponseEntity,HttpStatus.BAD_REQUEST);
	}

}
