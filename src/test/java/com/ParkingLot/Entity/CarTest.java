package com.ParkingLot.Entity;

import com.ParkingLot.Exceptions.RegistrationNumberIsNullException;
import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void should_Test_Create_Car_With_Registration_Number_And_Colour() throws RegistrationNumberIsNullException {
        String regNo = "1234";
        String colour = "Blue";
        Car car = new Car(regNo, colour);
        Assert.assertEquals(car.getRegistrationNumber(), regNo);
        Assert.assertEquals(car.getColour(), colour);

    }

    @Test(expected = RegistrationNumberIsNullException.class)
    public void should_Test_Registration_Number_Is_Not_Null() throws RegistrationNumberIsNullException {
        String regNo = null;
        String colour = "Blue";
        new Car(regNo,colour);
    }
}
