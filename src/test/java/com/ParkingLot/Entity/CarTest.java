package com.ParkingLot.Entity;

import com.ParkingLot.Exceptions.InvalidCarDataException;
import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void should_Test_Create_Car_With_Registration_Number_And_Colour() throws InvalidCarDataException {
        String regNo = "1234";
        String colour = "Blue";
        Vehicle car = new Car(regNo, colour);
        Assert.assertEquals(car.getRegistrationNumber(), regNo);
        Assert.assertEquals(car.getColour(), colour);

    }

    @Test(expected = InvalidCarDataException.class)
    public void should_Test_If_Registration_Number_Is_Null() throws InvalidCarDataException {
        String regNo = null;
        String colour = "Blue";
        new Car(regNo,colour);
    }

    @Test(expected = InvalidCarDataException.class)
    public void should_Test_If_Colour_Is_Null() throws InvalidCarDataException {
        String regNo = "1234";
        String colour = null;
        new Car(regNo,colour);
    }
}
