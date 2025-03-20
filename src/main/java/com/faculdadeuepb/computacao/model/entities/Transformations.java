package com.faculdadeuepb.computacao.model.entities;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;


public class Transformations{

    public static void transformDateFormat() throws IOException {

        File games = new File("games.csv");
        File gamesFormatedDate = new File("games_formated_release_data.csv");

        CSVParser csvParser = CSVCreate.createReader(games);
        CSVPrinter csvPrinter = CSVCreate.createWriter(gamesFormatedDate, csvParser);

        for (CSVRecord record : csvParser) {
            List<String> row = record.toList();
            row.set(2, Date.convertDate(record.get("Release date")));
            csvPrinter.printRecord(row);
        }
        csvPrinter.flush();

    } 
        
    public static void transformPortugueseAndLinux() throws IOException {

        File gamesFormatedDate = new File("games_formated_release_data.csv");
        File gamesFormatedSupportLinux = new File("games_linux.csv");
        File gamesFormatedSupportPortuguese = new File("portuguese_supported_games.csv");
        CSVParser csvParser = CSVCreate.createReader(gamesFormatedDate);
        CSVPrinter csvPrinterLinux = CSVCreate.createWriter(gamesFormatedSupportLinux, csvParser);
        CSVPrinter csvPrinterPortuguese = CSVCreate.createWriter(gamesFormatedSupportPortuguese, csvParser);
        
        List<CSVRecord> records = csvParser.getRecords();

        for (CSVRecord record : records) {
            boolean linuxSupport = Boolean.parseBoolean(record.get(19));
            if (linuxSupport) {
                csvPrinterLinux.printRecord(record); 
            }
        }

        for (CSVRecord record : records) {
            String line = record.get(10);
            if (line != null && !line.trim().isEmpty()) {  
                String cleanedLanguages = line.replaceAll("[\\[\\]']", "").trim();
                String[] languages = cleanedLanguages.split("\\s*,\\s*");
                for (String language : languages) {
                    if ("Portuguese - Brazil".equalsIgnoreCase(language)) {
                        csvPrinterPortuguese.printRecord(record);
                    }
                }
            }
        }

        csvPrinterLinux.flush();
        csvPrinterPortuguese.flush();
    
    }

    public static void createFiles(){
        try {
            System.out.println("Generating 'games_formated_release_data.csv'");
            Transformations.transformDateFormat();
            System.out.println("Done\n");

            System.out.println("Generating 'portuguese_supported_games.csv' and 'games_linux.csv' files.");
            Transformations.transformPortugueseAndLinux();
            System.out.println("Done");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}