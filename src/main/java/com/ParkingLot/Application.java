package com.ParkingLot;

import com.ParkingLot.Entity.Car;
import com.ParkingLot.Entity.ParkingLot;
import com.ParkingLot.Entity.Vehicle;
import com.ParkingLot.Exceptions.InvalidCarDataException;
import com.ParkingLot.Service.ParkingSpace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String args[]) throws IOException, InvalidCarDataException {
        String input;
        ParkingSpace parkingSpace = null;
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        List<String> result;
        List<Integer> lotNumbers;
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
                    Vehicle car=null;
                    if(st.countTokens()==2) {
                        String registrationNumber=st.nextToken();
                        String colour=st.nextToken();
                        car = new Car(registrationNumber,colour );
                    } else {
                        throw new InvalidCarDataException("Invalid car data.");
                    }
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
                    List<ParkingLot> status;
                    status=parkingSpace.status();
                    if(status==null) {
                        System.out.println("No cars parked yet.");
                    } else {
                        System.out.println("Status");
                        for(ParkingLot parkingLot : status) {
                            System.out.println(parkingLot.getLotNumber()+" "+
                                    parkingLot.getVehicle().getRegistrationNumber()+" "+
                                    parkingLot.getVehicle().getColour());
                        }
                    }
                    break;
                case "leave":
                    int lotNumber=Integer.parseInt(st.nextToken());
                    parkingSpace.leave(lotNumber);
                    System.out.println(lotNumber+" is free.");
                    break;
                case "registration_numbers_for_cars_with_colour":
                    String colour=st.nextToken();
                    result=parkingSpace.findRegistrationNumberByColour(colour);
                    System.out.println("Registration Number for cars with colour "+colour);
                    if(result.size()==0) {
                        System.out.println("No cars found with colour "+ colour);
                    } else {
                        for(String registrationNumber : result) {
                            System.out.println(registrationNumber);
                        }
                    }
                    break;
                case "slot_numbers_for_cars_with_colour":
                    colour=st.nextToken();
                    lotNumbers=parkingSpace.findSlotNumberByColour(colour);
                    System.out.println("lot Number for cars with colour "+colour);
                    if(lotNumbers.size()==0) {
                        System.out.println("No cars found with colour "+ colour);
                    } else {
                        for(Integer lotNo : lotNumbers) {
                            System.out.println(lotNo);
                        }
                    }
                    break;
                case "slot_number_for_registration_number":
                    String registrationNumber=st.nextToken();
                    lotNumber=parkingSpace.findSlotNumberByRegistrationNumber(registrationNumber);
                    if(lotNumber==0) {
                        System.out.println("No car found with registrationNumber "+ registrationNumber);
                    } else {
                        System.out.println(registrationNumber +" is parked in lot " +lotNumber);

                    }
                    break;

            }
        }
    }

}
