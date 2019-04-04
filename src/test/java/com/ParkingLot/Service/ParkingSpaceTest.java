package com.ParkingLot.Service;

import com.ParkingLot.Entity.Car;
import com.ParkingLot.Entity.ParkingLot;
import com.ParkingLot.Entity.Vehicle;
import com.ParkingLot.Exceptions.InvalidCarDataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpaceTest {

    ParkingSpace parkingSpace;
    ParkingLot parkingLot;
    Vehicle car;
    Vehicle car1;
    @Before
    public void setup() throws InvalidCarDataException {
        parkingSpace = new ParkingSpace(3);
        car= new Car("1234","blue");
        car1= new Car("1234","white");
    }

    @Test
    public void should_Test_Car_Is_Parked() {
        ParkingLot availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        Assert.assertEquals(availableLot.getVehicleRegistrationNumber(),"1234");
    }

    @Test
    public void should_Test_All_Lots_Are_Full() {
        ParkingLot availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        Assert.assertNull(parkingSpace.findAvailableLot());

    }

    @Test
    public void should_Test_Leave_Car() {
        ParkingLot availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        parkingSpace.leave(availableLot.getLotNumber());
        Assert.assertNull(availableLot.getVehicle());
        Assert.assertEquals(availableLot.getIsLotEmpty(),true);
    }

    @Test
    public void should_Test_Find_Registration_By_colour() {
        ParkingLot availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car1);
        Assert.assertEquals(parkingSpace.findRegistrationNumberByColour("blue").get(0),"1234");
    }

    @Test
    public void should_Test_Find_Lot_Number_By_colour() {
        ParkingLot availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car1);
        Assert.assertEquals(parkingSpace.findSlotNumberByColour("blue").get(0).intValue(),1);
    }

    @Test
    public void should_Test_Find_Lot_Number_By_Registration_Number() {
        ParkingLot availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car1);
        Assert.assertEquals(parkingSpace.findSlotNumberByRegistrationNumber("1234"),1);
    }

    @Test
    public void should_Test_Find_Lot_Number_By_Registration_Number_If_No_Cars_Found() {
        ParkingLot availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car1);
        Assert.assertEquals(parkingSpace.findSlotNumberByRegistrationNumber("12345"),0);
    }

    @Test
    public void should_Test_Status() {
        List<ParkingLot> status=new ArrayList<>();
        ParkingLot availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car);
        status.add(availableLot);
        availableLot = parkingSpace.findAvailableLot();
        parkingSpace.park(availableLot,car1);
        status.add(availableLot);
        Assert.assertArrayEquals((parkingSpace.status().toArray()),status.toArray());
    }
}
