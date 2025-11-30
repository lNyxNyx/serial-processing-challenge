package com.sidnei.desafio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1- Tarefa
        List<String> serialsWithoutDV = SerialValidator.validateSerialLength(FileReaderService.readLinesFromFile("serieSemDV.txt"), 14);
        
        List<String>  serialsWithDV = SerialProcessor.calculateCheckDigit(SerialProcessor.convertToAsciiMap(serialsWithoutDV));
    
        FileWriterService.writeLinesToFile(serialsWithDV, "serieComDV.txt");

        //2- Tarefa
        List<String> serialsToCheck = FileReaderService.readLinesFromFile("serieParaVerificar.txt");
        List<String> serialsValid = SerialValidator.validateSerialLength(serialsToCheck, 16);
        List<String> serials =  SerialProcessor.extractSerialNumber(serialsValid);
        List<String> listSerialsValid = SerialProcessor.calculateCheckDigit(SerialProcessor.convertToAsciiMap(serials));
        FileWriterService.writeLinesToFile(SerialValidator.isValidSerialNumber(serialsToCheck, listSerialsValid), "serieVerificada.txt");

        //3- Tarefa
        List<String> reportLines = FileReaderService.readLinesFromFile("serieParaRelatorio.txt");
        List<String> countryCodeMap = FileReaderService.readLinesFromFile("paises.txt");
        FileWriterService.writeLinesToFile(SerialProcessor.listCarsByCountrySorted( SerialProcessor.parseCountryKeyValue(countryCodeMap), reportLines),"listaTotais.txt" );
    }
}