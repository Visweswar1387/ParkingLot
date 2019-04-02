package com.ParkingLot.Entity;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {
    @Test
    public void should_Test_Create_Car_With_Registration_Number_And_Colour() {
         String regNo="1234";
         String colour="Blue";
         Car car = new Car(regNo,colour);
        Assert.assertEquals(car.getRegistrationNumber(),regNo);
        Assert.assertEquals(car.getColour(),colour);

    }
}
