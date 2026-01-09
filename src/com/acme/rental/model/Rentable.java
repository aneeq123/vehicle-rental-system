package com.acme.rental.model;

import java.time.LocalDateTime;

import com.acme.rental.exceptions.VehicleNotAvailableException;

public sealed interface Rentable permits Vehicle {
	
	// Start a Rental  (Like a Contract)
	
	void rent (LocalDateTime start, LocalDateTime end)
	throws VehicleNotAvailableException;
	
	
	// Finish a rental
	void returnVehicle(LocalDateTime actualEnd);
	
	
	// Default  method
	
	default boolean canBeRentedNow() {
		return true;
	}
	
	

	
	default void showPlannedPeriod(LocalDateTime start, LocalDateTime end) {
		logAction("Planned rental from " + start + " to " + end);
		
	}
	
	// Static Method //
	
// A fixed rule for all Rentable things: mscx rental time in hours.
	
	static int maxRentalHours() {
		return 24 * 7; // 7 days
	}

	// Private Helper //
	
	// Used only inside this interface (by default methods).
	private void logAction(String text) {
	System.out.println("[Rentable] " + text);
	}
	

}
