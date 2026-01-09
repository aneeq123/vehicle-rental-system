package com.acme.rental;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.acme.rental.billing.BookingService;
import com.acme.rental.exceptions.VehicleNotAvailableException;
import com.acme.rental.model.Bike;
import com.acme.rental.model.Booking;
import com.acme.rental.model.Car;
import com.acme.rental.model.EV;
import com.acme.rental.model.FleetCatalog;
import com.acme.rental.model.LicensePlate;
import com.acme.rental.model.Money;
import com.acme.rental.model.Van;
import com.acme.rental.model.Vehicle;
import com.acme.rental.util.VehiclePrinter;

public class MainAppTester {
	
	//  Simple console application used to demo the user stories.
	 // Creates a small sample fleet, runs a menu, and calls services.

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Services
        FleetCatalog catalog = new FleetCatalog();
        BookingService bookingService = new BookingService();

        // // Sample vehicles added to the catalog
        Vehicle car = new Car("C1", new LicensePlate("123-DUB"), Money.of("10.00", "EUR"), 5);
        Vehicle van = new Van("V1", new LicensePlate("45-GAL"), Money.of("14.00", "EUR"), 900);
        Vehicle ev = new EV("E1", new LicensePlate("99-ZZ"), Money.of("9.00", "EUR"), 60);
        Vehicle bike = new Bike("B1", new LicensePlate("BIKE1"), Money.of("4.00", "EUR"), "Road");
        
        Vehicle car1 = new Car("C2", new LicensePlate("123-CORK"), Money.of("20.00", "EUR"), 8);
        Vehicle ev1 = new EV("E2", new LicensePlate("98-GG"), Money.of("9.00", "EUR"), 60);
        Vehicle bike1 = new Bike("B2", new LicensePlate("BIKE3"), Money.of("2.00", "EUR"), "MountainBike");

        // Add to catalog
        catalog.addVehicle(car);
        catalog.addVehicle(van);
        catalog.addVehicle(ev);
        catalog.addVehicle(bike);
        catalog.addVehicle(car1);
        catalog.addVehicle(ev1);
        catalog.addVehicle(bike1);
        
        
        

        int choice;

        do {
            System.out.println("\n=== ACME Vehicle Rental ===");
            System.out.println("1. List all vehicles");
            System.out.println("2. List available vehicles");
            System.out.println("3. Show details for a vehicle");
            System.out.println("4. Create a booking (rent a vehicle)");
            System.out.println("5. List all bookings");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            // Validate numeric input
            while (!input.hasNextInt()) {
                System.out.print("Please enter a number: ");
                input.next();
            }
            choice = input.nextInt();
            
             // 1 ==  list everything
            if (choice == 1) {
                System.out.println("\nAll vehicles:");
                for (Vehicle v : catalog.listAll()) {
                	System.out.println(v + " -> " + VehiclePrinter.simpleLabel(v));
                }
            }
            
         // 2 ==  list only available vehicles
            if (choice == 2) {
                System.out.println("\nAvailable vehicles:");
                var available = catalog.listAvailable();    // uses LVTI

                if (available.isEmpty()) {
                    System.out.println("No vehicles are currently available to rent.");
                } else {
                    available.forEach(System.out::println); // method reference
                }
            }
            
         // 3 ==  show detailed info for a single vehicle
            if (choice == 3) {
                System.out.print("\nEnter vehicle id (e.g. C1): ");
                String id = input.next();
                Vehicle v = catalog.findById(id);
                if (v == null) {
                    System.out.println("No vehicle found with id: " + id);
                } else {
                    System.out.println(VehiclePrinter.detailedLabel(v));
                }
            }
            
            // 4 ==  create a booking (rent)
            if (choice == 4) {
                System.out.print("\nEnter vehicle id to rent: ");
                String id = input.next();
                Vehicle v = catalog.findById(id);
                if (v == null) {
                    System.out.println("No vehicle found with id: " + id);
                } else {
                    System.out.print("Enter number of hours to rent: ");
                    while (!input.hasNextInt()) {
                        System.out.print("Please enter a number: ");
                        input.next();
                    }
                    int hours = input.nextInt();
                    if (hours <= 0) {
                        System.out.println("Hours must be positive.");
                    } else {
                        LocalDateTime start = LocalDateTime.now();
                        LocalDateTime end = start.plusHours(hours);
                        try {
                            Booking booking = bookingService.createBooking(v, start, end);
                            System.out.println("Booking created:");
                            System.out.println(booking);
                            System.out.println("Vehicle is now marked as unavailable.");
                        } catch (VehicleNotAvailableException ex) {
                            System.out.println("Cannot create booking: " + ex.getMessage());
                        }

                    }
                }
            }

            // 5 == list bookings
            if (choice == 5) {
                System.out.println("\nAll bookings:");
                for (Booking b : bookingService.listBookings()) {
                    System.out.println(b);
                }
            }

            // // 6 == Exit the program
            if (choice == 6) {
                System.out.println("Program terminated.");
            }

        } while (choice != 6);

        input.close();
    }
}