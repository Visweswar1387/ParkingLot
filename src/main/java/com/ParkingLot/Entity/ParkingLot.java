package com.ParkingLot.Entity;

public class ParkingLot {
    private int lotNumber;
    private boolean isLotEmpty=true;
    private Vehicle vehicle;
    public ParkingLot(int lotNumber) {
        this.lotNumber=lotNumber;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public boolean getIsLotEmpty() {
        return isLotEmpty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle=vehicle;
        this.isLotEmpty=false;
    }

    public void leaveVehicle() {
        this.isLotEmpty=true;
        this.vehicle=null;
    }

    public String getVehicleRegistrationNumber() {
        if(this.getIsLotEmpty()) {
            return "No car Parked In lot " + this.lotNumber;
        }
        return this.vehicle.getRegistrationNumber();
    }

    public String getVehicleColour() {
        if(this.getIsLotEmpty()) {
            return "No car Parked In lot " + this.lotNumber;
        }
        return this.vehicle.getColour();
    }
}
