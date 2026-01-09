package com.acme.rental.model;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

//  immutable value object for a license plate.
public record LicensePlate (String value) {
	
	//Allow 1–10 characters: letters, digits or hyphen
	private static final Pattern PLATE = Pattern.compile("[A-Z0-9-]{1,10}");

    // constructor for validation and normalisation.
	public LicensePlate {
		
		// must not be null
		Objects.requireNonNull(value, "plate must not be null");
		
        // normalise spacing and case
        value = value.trim().toUpperCase(Locale.ROOT);
        
        // Validate against the allowed pattern; if not valid, throw an error
        if (!PLATE.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid license plate: " + value);
		
	}
        
	}
		
	
	@Override
	public String toString() {
		return value;
	}
	
}
