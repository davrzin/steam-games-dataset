package com.faculdadeuepb.computacao.model.entities;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

public class Transformations{

    public static String convertDate(String dateStr){

        DateTimeFormatter inputFormat, outputFormat;
        LocalDate date;

        inputFormat = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
        outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(isValidDate(dateStr, inputFormat)){
            date = LocalDate.parse(dateStr, inputFormat);
            return date.format(outputFormat);
        }
        
        inputFormat = DateTimeFormatter.ofPattern("MMM yyyy dd", Locale.ENGLISH);
        if(isValidDate(dateStr + " 01", inputFormat)){
            date = LocalDate.parse(dateStr + " 01", inputFormat);
            return date.format(outputFormat);
        }
        
        System.out.println("Error: Invalid date format");
        throw new DateTimeParseException("Invalid date format", dateStr, 0);
    }
    
    private static boolean isValidDate(String dateStr, DateTimeFormatter format){

        try{
            LocalDate.parse(dateStr, format);
            return true;
        } 
        catch(DateTimeParseException e){
            return false;
        }

    }

    public static void transformDateFormat(File file){
        File gamesFormatedDate = new File("games_formated_release_data.csv");
    
        try (Reader reader = new FileReader(file);
             CSVParser csvParser = new CSVParser(reader,CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build());
             Writer writer = new FileWriter(gamesFormatedDate);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.builder().setHeader(csvParser.getHeaderMap().keySet().toArray(new String[0])).build())) {
    
            for (CSVRecord record : csvParser) {
                List<String> row = record.toList();
                row.set(2, convertDate(record.get("Release date")));
    
                csvPrinter.printRecord(row);
            }

            csvPrinter.flush();
    
        } 
        
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void transformSupportLinux(File file) {
        File gamesFormatedSupportLinux = new File("games_linux.csv");
    
        try (Reader reader = new FileReader(file);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build());
             Writer writer = new FileWriter(gamesFormatedSupportLinux);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.builder().setHeader(csvParser.getHeaderMap().keySet().toArray(new String[0])).build())) {
    
            for (CSVRecord record : csvParser) {

                boolean linuxSupport = Boolean.parseBoolean(record.get(19));

                if (linuxSupport) {
                    csvPrinter.printRecord(record); 
                }
            }
    
            csvPrinter.flush();
    
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void transformPortugueseSupport(File file) {
        File gamesFormatedSupportPortuguese = new File("portuguese_supported_games.csv");
    
        try (Reader reader = new FileReader(file);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build());
             Writer writer = new FileWriter(gamesFormatedSupportPortuguese);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.builder().setHeader(csvParser.getHeaderMap().keySet().toArray(new String[0])).build())) {
    
            for (CSVRecord record : csvParser) {

                String line = record.get("Full audio languages");

                if (line != null && !line.trim().isEmpty()) {
                    
                    String cleanedLanguages = line.replaceAll("[\\[\\]']", "").trim();

                    String[] languages = cleanedLanguages.split("\\s*,\\s*");

                    for (String language : languages) {
                        if ("Portuguese - Brazil".equalsIgnoreCase(language)) {
                            csvPrinter.printRecord(record);
                        }
                    }
                }
            }
            csvPrinter.flush();
        } 
        
        catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}