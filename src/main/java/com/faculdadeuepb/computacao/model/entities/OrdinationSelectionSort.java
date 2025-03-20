package com.faculdadeuepb.computacao.model.entities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class OrdinationSelectionSort {

    public static void countLinesColumnsCsv() throws IOException{

        File gamesFormatedDate = new File("games_formated_release_data.csv");
        File gamesFormatedSelectionSort = new File("games_release_date_SelectionSort.csv");

        CSVParser csvParser = CSVCreate.createReader(gamesFormatedDate);
        CSVPrinter csvPrinter = CSVCreate.createWriter(gamesFormatedSelectionSort, csvParser);

        int[] resultados = new int[2];
        int linhas = 0;
        int colunas = 0;
        CSVRecord lastRecord = null;

        List<CSVRecord> records = csvParser.getRecords();
        
        for (CSVRecord record : records){
            linhas++;
            lastRecord = record;  
        }

        if(lastRecord != null)
            colunas = lastRecord.size();

        resultados[0] = linhas;
        resultados[1] = colunas;

        String[][] dados = new String[resultados[0]][resultados[1]];

        int count = 0; 

        for (CSVRecord record : records){
            for (int j = 0; j < record.size(); j++){
                dados[count][j] = record.get(j);
            }
            count++;
        }

        int rows = dados.length;
        String[][] dadosOrdenados = SelectionSort(dados,rows);

        for (int i = 0; i < rows; i++) {
            csvPrinter.print(Arrays.toString(dadosOrdenados[i]));
            csvPrinter.println();
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

    public static String[][] SelectionSort(String[][] dadosArray,int rows){

        for (int i = 0; i < rows-1; i++) {
            int minIndex = i;
            for (int j = i+1; j<rows; j++) {
                if (checkDateSize(dadosArray[j][2], dadosArray[minIndex][2])) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                String[] temp = dadosArray[i];
                dadosArray[i] = dadosArray[minIndex];
                dadosArray[minIndex] = temp;
            }
            //System.err.println("-" + i);
        }

        return dadosArray;

    }

    public static void ordenandoSelectionSort(){
        try {
            System.out.println("Generating 'games_release_date_SelectionSort.csv'");
            countLinesColumnsCsv();
        } 
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
       
    }

}
