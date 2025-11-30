package com.sidnei.desafio;

import java.util.List;
import java.util.ArrayList;


public class SerialValidator {

    public static List<String> validateSerialLength( List<String> serials, int expectedLength ) {
        List<String> validSerials = new ArrayList<>();
        for (String serial : serials) {
            if (serial.length() != expectedLength) {
                System.out.println("Serial " + serial + " is invalid.");
            } else {
                validSerials.add(serial);                
            }
        }
        return validSerials;
    }

    public static List<String> isValidSerialNumber( List<String> listSeriesToCheck,List<String> validatedList ) {
         List<String> seriesVerified = new ArrayList<>();
        for (String serialToCheck : listSeriesToCheck) {
            if (validatedList.contains(serialToCheck)) {
                seriesVerified.add(serialToCheck +" verdadeiro");
            } else {
                seriesVerified.add(serialToCheck +" falso");
            }
        }
        return seriesVerified;
    }

 
}   
