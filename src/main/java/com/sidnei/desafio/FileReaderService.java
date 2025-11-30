package com.sidnei.desafio;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileReaderService {

    public static List<String> readLinesFromFile( String pathFile){
  
        String path = "src/main/resources/data/input/" + pathFile;
        List<String> listSerial = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String serialNumber;
            while ((serialNumber = br.readLine()) != null) {
                listSerial.add(serialNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listSerial;
    }
}


