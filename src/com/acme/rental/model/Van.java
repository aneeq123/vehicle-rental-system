package com.acme.rental.model;

import java.time.LocalDate;

public final class Van extends Vehicle {
	
	private int cargoVolumeLitres;
	
	
	public Van(String id, LicensePlate plate, Money baseRatePerHour, int cargoVolumeLitres, LocalDate addedOn)
	{
		//Super class
		super(id, plate, VehicleType.VAN, true, baseRatePerHour, addedOn);
		this.cargoVolumeLitres = cargoVolumeLitres;
		
	}
		
		//secondary constructor
		public Van(String id,LicensePlate plate, Money baseRatePerHour, int cargoVolumeLitres)
		{
			this(id,plate, baseRatePerHour, cargoVolumeLitres, LocalDate.now());
		

}

	public int getCargoVolumeLitres() {
		return cargoVolumeLitres;
	}
	
	
	// implement the abstarct method from vehicle
	@Override
	public String vehicleCategory() {
		return "Van";
	}


	@Override
	public String toString() {
		return super.toString() + ", cargoVolumeLitres=" + cargoVolumeLitres;
	}	

}
