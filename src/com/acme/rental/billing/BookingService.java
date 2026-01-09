package com.acme.rental.billing;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.acme.rental.exceptions.VehicleNotAvailableException;
import com.acme.rental.model.Booking;
import com.acme.rental.model.BookingId;
import com.acme.rental.model.Money;
import com.acme.rental.model.Vehicle;
import java.util.List;

public class BookingService {
	
	// // Used to calculate rental prices
	private final PricingService pricingService = new PricingService();
	
	// Stores all bookings (internal list)
	private final ArrayList<Booking> bookings = new ArrayList<>();

	
	// Create a booking for one Vehicle
	
	public Booking createBooking(Vehicle vehicle, LocalDateTime start, LocalDateTime end)
	throws VehicleNotAvailableException {
		
		// validation
		 if (vehicle == null || start == null || end == null) {
	            throw new IllegalArgumentException("vehicle, start or end is null");
	        }

		 	// Calculate rental price using PricingService
	        Money price = pricingService.price(vehicle, start, end);

	        // mark vehicle as rented
	        vehicle.rent(start, end);

	        // simple id: BKG-1, BKG-2, ...
	        String rawId = "BKG-" + (bookings.size() + 1);
	        BookingId id = new BookingId(rawId);

	     // Create the booking record and save it
	        Booking booking = new Booking(id, vehicle.getId(), start, end, price);
	        bookings.add(booking);

	        return booking;
	    }
	
	// Return a copy so callers cannot change internal list
	
	public List<Booking> listBookings() {
		return new ArrayList<>(bookings);
	}
		
	}


