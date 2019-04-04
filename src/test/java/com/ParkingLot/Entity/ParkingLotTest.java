package com.ParkingLot.Entity;

import com.ParkingLot.Exceptions.InvalidCarDataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingLot parkingLot;
    Vehicle car;
    @Before
    public void setup() throws InvalidCarDataException {
         parkingLot = new ParkingLot(1);
         car= new Car("1234","blue");
    }

    @Test
    public void should_Test_Lot_number() {
        Assert.assertEquals(parkingLot.getLotNumber(),1);
    }

    @Test
    public void should_Test_Lot_Is_Empty_If_Car_Is_Not_Parked() {
        Assert.assertEquals(parkingLot.getIsLotEmpty(), true);
    }

    @Test
    public void should_Test_Lot_Is_Empty_If_Car_Is_Parked() {
        parkingLot.parkVehicle(car);
        Assert.assertEquals(parkingLot.getIsLotEmpty(), false);
    }

    @Test
    public void should_Test_Get_Car_If_Car_Is_Parked() {
        parkingLot.parkVehicle(car);
        Assert.assertNotNull(parkingLot.getVehicle());
    }

    @Test
    public void should_Test_Lot_Is_Empty_After_Car_Is_Left() {
        parkingLot.parkVehicle(car);
        parkingLot.leaveVehicle();
        Assert.assertEquals(parkingLot.getIsLotEmpty(), true);
        Assert.assertNull(parkingLot.getVehicle());
    }

    @Test
    public void should_Test_getVehicleRegistrationNumber_Parked_In_Lot() {
        parkingLot.parkVehicle(car);
        Assert.assertEquals(parkingLot.getVehicleRegistrationNumber(),"1234");
    }

    @Test
    public void should_Test_getVehicleColour_Parked_In_Lot() {
        parkingLot.parkVehicle(car);
        Assert.assertEquals(parkingLot.getVehicleColour(),"blue");
    }

    @Test
    public void should_Test_No_Car_Found_Message_If_Car_Is_Not_parked() {
        Assert.assertEquals(parkingLot.getVehicleColour(),"No car Parked In lot 1");
        Assert.assertEquals(parkingLot.getVehicleRegistrationNumber(),"No car Parked In lot 1");
    }
}
