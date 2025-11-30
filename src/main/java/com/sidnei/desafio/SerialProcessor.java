package com.sidnei.desafio;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;


public class SerialProcessor {

   public static Map<String, List<Integer>> convertToAsciiMap(List<String> listSerial) {
        Map<String, List<Integer>> listSerialASCII = new java.util.LinkedHashMap<>();
        for (int i = 0; i < listSerial.size(); i++) {
            String serial = listSerial.get(i);
           

            List<Integer> listASCII = new ArrayList<>();
            for (int j = 0; j < serial.length(); j++) {
                char c = serial.charAt(j);
                listASCII.add((int) c);
            }

            listSerialASCII.put(serial, listASCII);
        }
        return listSerialASCII;
    }

    public static List<String> calculateCheckDigit( Map<String, List<Integer>> listSerialASCII) {
        List<String> listVerifiedDigit = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> serial : listSerialASCII.entrySet()) {
            String series = serial.getKey();
            List<Integer> asciiValues = serial.getValue();
            int total = 0;
            for (int value : asciiValues) {
                total += value;
            }
            int result = total % 16;
            String validatedSerial = series + '-' + convertToHex(result);
            listVerifiedDigit.add(validatedSerial); 
        }
        return listVerifiedDigit;
    }

    public static String convertToHex(int result) {
        String hex = Integer.toHexString(result).toUpperCase();
        return hex;
    }

    public static List<String> extractSerialNumber( List<String> listSerial) {
        return listSerial.stream()
            .map(serial -> serial.substring(0, 14))
            .collect(Collectors.toList());
    }


    public static Map<String, String> parseCountryKeyValue(List<String> listCountries){
        Map<String, String> countryKeyValue = new java.util.HashMap<>();
        for (String country  : listCountries) {
            String[] part = country.split(";");
            if (part.length == 2) {
                countryKeyValue.put(part[0], part[1]);
            }
        }
        return countryKeyValue;
    }

    public static  List<String> listCarsByCountrySorted (Map<String, String> countryKeyValue, List<String>listSeriesReport){ 
        Map<String, Integer> listcountryCount = new java.util.HashMap<>();

        for(String serial : listSeriesReport) {
            for (Map.Entry<String, String> countryKey : countryKeyValue.entrySet()) {    
                String countryName = countryKey.getValue();

                if( serial.contains(countryKey.getKey())) {
                    listcountryCount.put(countryName, listcountryCount.getOrDefault(countryName, 0) + 1);
                }           
            }
        }  
       return sortCountryCount(listcountryCount);
    }

    public static  List<String> sortCountryCount(Map<String, Integer>listcountryCount) {
        return listcountryCount.entrySet().stream()
            .map(serial -> serial.getKey() + "-" + serial.getValue())
            .sorted()
            .collect(Collectors.toList());  
    }
}
   
