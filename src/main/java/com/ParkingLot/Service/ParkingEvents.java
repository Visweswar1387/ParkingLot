package com.ParkingLot.Service;

import com.ParkingLot.Entity.Car;
import com.ParkingLot.Entity.ParkingLot;

public interface ParkingEvents {
     void park(ParkingLot availableLot,Car car);
     void status();
     ParkingLot findAvailableLot();
     void leave(int lotNumber);
}
