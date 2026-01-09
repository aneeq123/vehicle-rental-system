package com.acme.rental.exceptions;

// Unchecked exception: extends RuntimeException
public class FleetOperationException extends RuntimeException {

	public FleetOperationException(String message) {
		super(message);
	}
	
}
