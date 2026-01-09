package com.acme.rental.model;

import java.time.LocalDate;

public final class Car extends Vehicle {
	
	private  int seats;
	
	public Car(String id, LicensePlate plate, Money baseRatePerHour, int seats, LocalDate addedOn)
	{
		//Super class
		super(id, plate, VehicleType.CAR, true, baseRatePerHour, addedOn);
		this.seats = seats;
		
	}
		
		//secondary constructor
		public Car(String id,LicensePlate plate, Money baseRatePerHour, int seats)
		{
			this(id,plate, baseRatePerHour, seats, LocalDate.now());
		

}

	public int getSeats() {
		return seats;
	}
	
	
	// implement the abstarct method from vehicle
	@Override
	public String vehicleCategory() {
		return "Car";
	}


	@Override
	public String toString() {
		return super.toString() + ", seats=" + seats;
	}	
	
}
	

