package com.acme.rental.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


 //  A Booking represents one rental of a vehicle.
 
public record Booking(
        BookingId id,
        String vehicleId,
        LocalDateTime start,
        LocalDateTime end,
        Money totalPrice) {

    // Date formatter 
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Booking {
        if (id == null) {
            throw new IllegalArgumentException("booking id is null");
        }
        if (vehicleId == null || vehicleId.isBlank()) {
            throw new IllegalArgumentException("vehicleId is blank");
        }
        if (start == null || end == null) {
            throw new IllegalArgumentException("start or end is null");
        }
        if (totalPrice == null) {
            throw new IllegalArgumentException("totalPrice is null");
        }
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nBooking Details\n");
        sb.append("----------------------\n");
        sb.append("Booking ID : ").append(id).append("\n");
        sb.append("Vehicle ID : ").append(vehicleId).append("\n");
        sb.append("Start Time : ").append(start.format(FMT)).append("\n");
        sb.append("End Time   : ").append(end.format(FMT)).append("\n");
        sb.append("Total Price: ").append(totalPrice).append("\n");
        return sb.toString();
    }
}