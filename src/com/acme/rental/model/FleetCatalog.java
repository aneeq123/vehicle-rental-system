package com.acme.rental.model;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// FleetCatalog stores and manages the list of vehicles

public class FleetCatalog {  
	
	
	// Array
	private final Vehicle[] seed;
	
	private final ArrayList<Vehicle> fleet = new ArrayList<>();
	
	// Empty catalog constructor.
	// Creates a catalog with no initial vehicles.
	public FleetCatalog() {
		this.seed = new Vehicle[0];
		
	}
	
	// Start with initial Array
	public FleetCatalog(Vehicle[] initial) {
		// keep a copy of the array (Defensive)
		this.seed = initial == null ?
		new Vehicle[0] : initial.clone();
		
		// Load the array items into the ArrayList
		for (var v : this.seed) {
			if (v != null) {
				fleet.add(v);
			}
		}
		
	}
	
	// How many Vehicle are in the working list?
	public int size() {
		return fleet.size();
		
	}
	
	// Return a copy so callers can't modify our internal list directly
	public List<Vehicle> listAll() {
		return new ArrayList<>(fleet);  //Defensive copy
	}
	
	// Give back a copy of the original array
	public Vehicle[] seedArray() {
		return seed.clone();
	}
	
	// Add one Vehicle
	public void addVehicle(Vehicle v) {
		if (v != null) {
			fleet.add(v);
		}
	}
	
	// Add many Vehicles at once (varargs)
	public void addVehicles(Vehicle... vs) {
		if (vs == null) return;
		for (var v : vs) {
			if (v != null) {
				fleet.add(v);
			}
		}
	}
	
	// Find a Vehicle by its id (returns null if not found)
	public Vehicle findById(String id) {
		if (id == null)
			return null;
		for (var v : fleet) {
			if (id.equals(v.getId())) {
				return v;
				
			}
		}
		return null;
	}

	
	// Add filtering with predicate
	public List<Vehicle> filter (Predicate<Vehicle> rule) {
		var result = new ArrayList<Vehicle>();
		if (rule == null)
			return result;
		
		for (var v : fleet) {
			if (rule.test(v)) {
				result.add(v);
				
			}
		}
		return result;
		
	}
	
	// Available Vehicle
	public List<Vehicle> listAvailable() {
		return filter(Vehicle::isAvailable); // Method reference
		
		
	}
	
	
	// By type
		public List<Vehicle> listByType(VehicleType type) {
			return filter(v -> v.getType() == type); // lambda
			
			
		}
	
	

	
	

}
