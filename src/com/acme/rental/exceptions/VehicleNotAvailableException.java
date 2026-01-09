package com.acme.rental.exceptions;

public class VehicleNotAvailableException extends Exception {
	
	// Checked excpetion: extends Exception
	
	public VehicleNotAvailableException (String message) {
		super(message);
	}

}
