package com.faculdadeuepb.computacao.model.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Date {
    
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

    public static Boolean checkDateSize(String primeiraData, String segundaData){

        String[] primeiraDataForm = primeiraData.split("/");
        String[] segundaDataForm = segundaData.split("/");

        int dia1 = Integer.parseInt(primeiraDataForm[0]);
        int mes1 = Integer.parseInt(primeiraDataForm[1]);
        int ano1 = Integer.parseInt(primeiraDataForm[2]);

        int dia2 = Integer.parseInt(segundaDataForm[0]);
        int mes2 = Integer.parseInt(segundaDataForm[1]);
        int ano2 = Integer.parseInt(segundaDataForm[2]);

        if (ano1 > ano2) {
            return false;
        } 
        
        else if (ano1 == ano2 && mes1 > mes2) {
            return false;
        } 
        
        else if (ano1 == ano2 && mes1 == mes2 && dia1 > dia2) {
            return false;
        }

        return true;
    }

}
