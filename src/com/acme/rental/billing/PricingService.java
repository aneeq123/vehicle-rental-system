package com.acme.rental.billing;

import java.time.Duration;
import java.time.LocalDateTime;

import com.acme.rental.model.Money;
import com.acme.rental.model.Vehicle;
import com.acme.rental.model.VehicleType;
import java.math.BigDecimal;

public class PricingService {
	
	private static final String CURRENCY = "EUR";
	
	// Method 1: All prices are returned in EUR
	
	public Money price(Vehicle vehicle, Duration duration) {
		
		// Basic validation
		if (vehicle == null || duration == null) {
			throw new IllegalArgumentException("vehicle or suration is null");
			
		}
		
		// Convert duration → hours (minimum charge is 1 hour)
		long hours = duration.toHours();
		if (hours <= 0) {
			hours = 1; // minimum 1 hour
		}
		
		//// Get the hourly rate based on vehicle type
		Money hourlyRate = hourlyRateFor(vehicle.getType());
		
		
		// // Calculate total price: rate × hours
		
		BigDecimal totalAmount = hourlyRate.getAmount().multiply(BigDecimal.valueOf(hours));
		return new Money(totalAmount, CURRENCY);
	}
		
		// Method 2: (overload): price using start and end times
		
		public Money price(Vehicle vehicle, LocalDateTime start, LocalDateTime end) {
			
			//// Validate timestamps
			if (start == null || end == null) {
				throw new IllegalArgumentException("start or end is null");
			}
			
			//Convert start/end → Duration and reuse the main method above
			Duration d = Duration.between(start, end);
			return price(vehicle, d); // calls the other price (...) method
			
		}
		
		//Helper: Returns hourly rate based on VehicleType 
		// Using a switch expression
		private Money hourlyRateFor(VehicleType type) {
		
		String amount = switch (type) {
		case CAR -> "10.00";
		case VAN -> "14.00";
		case EV  -> "9.00";
		case BIKE -> "4.00";
		};
		
		return Money.of(amount, CURRENCY);
		
		
	}

}
