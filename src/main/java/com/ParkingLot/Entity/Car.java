package com.ParkingLot.Entity;

import com.ParkingLot.Exceptions.InvalidCarDataException;

public class Car extends Vehicle {
    private String registrationNumber;
    private String colour;
    public Car(String regNo, String colour) throws InvalidCarDataException {
        if(regNo == null || colour == null) {
            throw new InvalidCarDataException("Invalid car data.");
        }
        this.registrationNumber=regNo;
        this.colour=colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColour() {
        return colour;
    }
}
