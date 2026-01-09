package com.acme.rental.model;

import java.time.LocalDate;

public final class EV extends Vehicle  {

	private int batteryKWh;
	
	public EV(String id, LicensePlate plate, Money baseRatePerHour, int batteryKWh, LocalDate addedOn)
	{
		//Super class
		super(id, plate, VehicleType.EV, true, baseRatePerHour, addedOn);
		this.batteryKWh = batteryKWh;
		
	}
		
		//secondary constructor
		public EV(String id,LicensePlate plate, Money baseRatePerHour, int batteryKWh)
		{
			this(id,plate, baseRatePerHour, batteryKWh, LocalDate.now());
		

}

	public int getbatteryKWh() {
		return batteryKWh;
	}
	
	
	// implement the abstarct method from vehicle
	@Override
	public String vehicleCategory() {
		return "EV";
	}


	@Override
	public String toString() {
		return super.toString() + ", batteryKWh=" + batteryKWh;
	}	

}
