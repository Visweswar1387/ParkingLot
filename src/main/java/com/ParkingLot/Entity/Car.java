package com.ParkingLot.Entity;

public class Car {
    private String registrationNumber;
    private String colour;
    public Car(String regNo, String colour) {
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
