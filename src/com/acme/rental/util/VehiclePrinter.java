package com.acme.rental.util;

import com.acme.rental.model.*;

public final class VehiclePrinter {

    private VehiclePrinter() {}

    public static String simpleLabel(Vehicle v) {
        if (v == null) return "unknown vehicle";
        if (v instanceof Car c) return "Car with " + c.getSeats() + " seats";
        if (v instanceof Van va) return "Van, cargo " + va.getCargoVolumeLitres() + " L";
        if (v instanceof EV e) return "EV, battery " + e.getbatteryKWh() + " kWh";
        if (v instanceof Bike b) return "Bike (" + b.getframeType() + ")";
        return "Vehicle type: " + v.getType();
    }

    // Simple, short detailed output using pattern-matching switch
    public static String detailedLabel(Vehicle v) {
        if (v == null) return "no vehicle";

        return switch (v) {
            case Car c -> detailsBase(v) + "Seats: " + c.getSeats() + "\n";
            case Van va -> detailsBase(v) + "Cargo Volume: " + va.getCargoVolumeLitres() + " L\n";
            case EV e -> detailsBase(v) + "Battery kWh: " + e.getbatteryKWh() + " kWh\n";
            case Bike b -> detailsBase(v) + "Frame Type: " + b.getframeType() + "\n";
            default -> detailsBase(v);
        };
    }

    // small helper to avoid repeating basic fields
    private static String detailsBase(Vehicle v) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nVehicle Details\n");
        sb.append("ID: ").append(v.getId()).append("\n");
        sb.append("Type: ").append(v.getType()).append("\n");
        sb.append("Plate: ").append(v.getPlate()).append("\n");
        sb.append("Available: ").append(v.isAvailable()).append("\n");
        sb.append("Rate/hr: ").append(v.getBaseRatePerHour()).append("\n");
        sb.append("Added on: ").append(v.getAddedOn()).append("\n");
        return sb.toString();
    }
}