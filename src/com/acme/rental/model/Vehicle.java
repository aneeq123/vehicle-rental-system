package com.acme.rental.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.acme.rental.exceptions.VehicleNotAvailableException;

//Base class for all vehicles in the fleet.
// Sealed so only Car, Van, EV and Bike can extend it.

public sealed abstract class Vehicle implements Rentable permits Car, Van, EV, Bike {
	
	
	
	//Fields
	private String id;
	private LicensePlate plate;
	private VehicleType type;
	private boolean available;     
	private Money   baseRatePerHour;
	private LocalDate addedOn;
	
	// Renting fields (After creating Rentable Interface)
	private boolean rented;
	private LocalDateTime rentStart;
	private LocalDateTime rentEnd;
	
	
	// Constructor 
	public Vehicle(String id, LicensePlate plate, VehicleType type, boolean available, Money baseRatePerHour,
			LocalDate addedOn) {
		this.id = id;
		this.plate = plate;
		this.type = type;
		this.available = available;
		this.baseRatePerHour = baseRatePerHour;
		this.addedOn = addedOn;
	}
	
	// Secondary Constructor 
	public Vehicle(String id, LicensePlate plate, VehicleType type, Money baseRatePerHour) {
	    this(id, plate, type, /* available*/ true,  baseRatePerHour, LocalDate.now());  // calling another constructor
	}
	
	
	// Getter and Setter
	
	//Getter
	
	public boolean isAvailable() {
		return available;
	}

	

	public String getId() {
		return id;
	}

	public LicensePlate getPlate() {
		return plate;
	}

	public VehicleType getType() {
		return type;
	}

	public Money getBaseRatePerHour() {
		return baseRatePerHour;
	}

	public LocalDate getAddedOn() {
		return addedOn;
	}
	
	
	//Setter
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	// Abstract Method
	
	public abstract String vehicleCategory();
	
	
	// toStting()
	
	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicle[")
        .append("id=").append(id)
        .append(", plate=").append(plate)
        .append(", type=").append(type)
        .append(", available=").append(available)
        .append(", rate=").append(baseRatePerHour)
        .append(", addedOn=").append(addedOn)
        .append("]");
        return sb.toString();
	}
	
	// Implement The two Methods from the Interface (Rentable implementation )

	@Override
	public void rent(LocalDateTime start, LocalDateTime end) throws VehicleNotAvailableException {
		
		if (rented) {
			throw new VehicleNotAvailableException("Vehicle is already rented ");
		}
		
		this.rented = true;
		this.rentStart = start;
		this.rentEnd = end;
		this.setAvailable(false);
		
	}

	@Override
	public void returnVehicle(LocalDateTime actualEnd) {
		
		this.rented = false;
		this.rentEnd = actualEnd;
		this.setAvailable(true);
		
	}
	
	public boolean isRented( ) {
		return rented;
	}
	
	
	
	
}
