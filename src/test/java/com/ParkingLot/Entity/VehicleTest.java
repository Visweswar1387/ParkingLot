package com.ParkingLot.Entity;

import org.junit.Assert;
import org.junit.Test;

public class VehicleTest {

    @Test
    public void should_Test_Get_Registration_Number_Is_Null()  {
        Vehicle car = new Vehicle() {};
        Assert.assertNull(car.getRegistrationNumber());
    }

    @Test
    public void should_Test_Get_Colour_Is_Null() {
        Vehicle car = new Vehicle() {};
        Assert.assertNull(car.getColour());
    }
}
