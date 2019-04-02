package com.ParkingLot.Service;

import com.ParkingLot.Entity.Car;
import com.ParkingLot.Entity.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace implements ParkingEvents {
    private List<ParkingLot> parkingLots;
    public ParkingSpace(int numberOfLots) {
        createParkingLots(numberOfLots);
    }

    private void createParkingLots(int numberOfLots) {
        parkingLots = new ArrayList<>(numberOfLots);
        for(int i=0;i<numberOfLots;i++) {
            parkingLots.add(new ParkingLot(i+1));
        }
    }


    @Override
    public void park(ParkingLot availableLot,Car car) {
        availableLot.parkCar(car);
    }

    @Override
    public void status() {
        for(ParkingLot parkingLot :parkingLots) {
            if(!parkingLot.getIsLotEmpty()) {
                System.out.println(parkingLot.getLotNumber()+" "+
                        parkingLot.getCar().getRegistrationNumber()+" "+
                        parkingLot.getCar().getColour());
            }
        }
    }

    @Override
    public ParkingLot findAvailableLot() {
        for(ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getIsLotEmpty()) {
                return parkingLot;
            }
        }
        return null;
    }

    @Override
    public void leave(int lotNumber) {
        parkingLots.get(lotNumber-1).setIsLotEmpty();
    }


}
