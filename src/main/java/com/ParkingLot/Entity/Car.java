package com.ParkingLot.Entity;

import com.ParkingLot.Exceptions.RegistrationNumberIsNullException;

public class Car {
    private String registrationNumber;
    private String colour;
    public Car(String regNo, String colour) throws RegistrationNumberIsNullException {
        if(regNo == null) {
            throw new RegistrationNumberIsNullException("Registration number is required.");
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
