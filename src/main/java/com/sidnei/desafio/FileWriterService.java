package com.sidnei.desafio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterService {

    public static void writeLinesToFile(List<String>listSerial, String nameFile) {

        String path = "src/main/resources/data/output/" + nameFile;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String serial : listSerial) {
                bw.write(serial);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
