package com.ParkingLot.Service;

import com.ParkingLot.Entity.ParkingLot;
import com.ParkingLot.Entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {
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


    public void park(ParkingLot availableLot, Vehicle car) {
        availableLot.parkVehicle(car);
    }

    public List<ParkingLot> status() {
        List<ParkingLot> parkingLotStatus=new ArrayList<>();
        for(ParkingLot parkingLot :parkingLots) {
            if(!parkingLot.getIsLotEmpty()) {
                parkingLotStatus.add(parkingLot);
            }
        }
        return parkingLotStatus;
    }

    public ParkingLot findAvailableLot() {
        for(ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getIsLotEmpty()) {
                return parkingLot;
            }
        }
        return null;
    }

    public void leave(int lotNumber) {
        parkingLots.get(lotNumber-1).leaveVehicle();
    }


    public List<String> findRegistrationNumberByColour(String vehicleColour) {
        List<String> registrationNumbers = new ArrayList<>();
        for(ParkingLot parkingLot : parkingLots ) {
            if(parkingLot.getVehicleColour().equals(vehicleColour)) {
                registrationNumbers.add(parkingLot.getVehicle().getRegistrationNumber());
            }
        }
        return registrationNumbers;
    }

    public List<Integer> findSlotNumberByColour(String vehicleColour) {
        List<Integer> slotNumbers = new ArrayList<>();
        for(ParkingLot parkingLot : parkingLots ) {
            if(parkingLot.getVehicleColour().equals(vehicleColour)) {
                slotNumbers.add(parkingLot.getLotNumber());
            }
        }
        return slotNumbers;
    }

    public int findSlotNumberByRegistrationNumber(String registrationNumber) {
        for(ParkingLot parkingLot :parkingLots) {
            if(parkingLot.getVehicleRegistrationNumber().equals(registrationNumber)) {
                return parkingLot.getLotNumber();
            }
        }
        return 0;
    }
}
