package com.ParkingLot;

import com.ParkingLot.Entity.Car;
import com.ParkingLot.Entity.ParkingLot;
import com.ParkingLot.Exceptions.InvalidCarDataException;
import com.ParkingLot.Service.ParkingSpace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Application {
    public static void main(String args[]) throws IOException, InvalidCarDataException {
        String input;
        ParkingSpace parkingSpace = null;
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        while ( (input = br.readLine()) != null ) {
            StringTokenizer st = new StringTokenizer(input);
            String event = st.nextToken();
            switch (event) {
                case "create_parking_lot":
                    int numberOfLots=Integer.parseInt(st.nextToken());
                    parkingSpace = new ParkingSpace(numberOfLots);
                    System.out.println("parking space is created with "+numberOfLots+" lots.");
                    break;
                case "park":
                    Car car = new Car(st.nextToken(), st.nextToken());
                    ParkingLot availableLot = parkingSpace.findAvailableLot();
                    if(availableLot!=null) {
                        parkingSpace.park(availableLot,car);
                        System.out.println("Car is parked at lot "+availableLot.getLotNumber());
                    }
                    else {
                        System.out.println("Sorry all lots are full");
                    }
                    break;
                case "status":
                    parkingSpace.status();
                    break;
                case "leave":
                    int lotNumber=Integer.parseInt(st.nextToken());
                    parkingSpace.leave(lotNumber);
                    System.out.println(lotNumber+" is free.");

            }
        }
    }

}
