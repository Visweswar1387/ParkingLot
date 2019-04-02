package com.ParkingLot.Entity;

public class ParkingLot {
    private int lotNumber;
    private boolean isLotEmpty=true;
    private Car car;
    public ParkingLot(int lotNumber) {
        this.lotNumber=lotNumber;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public boolean getIsLotEmpty() {
        return isLotEmpty;
    }

    public Car getCar() {
        return car;
    }

    public void parkCar(Car car) {
        this.car=car;
        this.isLotEmpty=false;
    }

    public void setIsLotEmpty() {
        this.isLotEmpty=true;
        this.car=null;
    }
}
