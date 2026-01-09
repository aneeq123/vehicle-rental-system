package com.acme.rental.model;

import java.time.LocalDate;

public final class Bike extends Vehicle {
	
	private String frameType; // e.g "Road", "Mountain", "Hybrid"
	
	public Bike(String id, LicensePlate plate, Money baseRatePerHour, String frameType, LocalDate addedOn)
	{
		//Super class
		super(id, plate, VehicleType.BIKE, true, baseRatePerHour, addedOn);
		this.frameType = frameType;
		
	}
		
		//secondary constructor
		public Bike(String id,LicensePlate plate, Money baseRatePerHour, String frameType)
		{
			this(id,plate, baseRatePerHour, frameType, LocalDate.now());
		

}

	public String getframeType() {
		return frameType;
	}
	
	
	// implement the Abstract  method from vehicle
	@Override
	public String vehicleCategory() {
		return "Bike";
	}


	@Override
	public String toString() {
		return super.toString() + ", frameType=" + frameType;
	}	


}
