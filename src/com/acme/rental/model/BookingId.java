package com.acme.rental.model;

public record BookingId(String value) {
	
	public BookingId {
		// Ensures the id is not null or blank.
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("Booking id is blank");
		}
	}

	@Override
	public String toString() {
		return value;
	}
	
	


}
