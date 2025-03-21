package com.faculdadeuepb.computacao.model.utils;

import java.io.File;
import java.io.IOException;

import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class Ordination {

    public static void generateCsvSorted(String sortingMethod) throws IOException {

        File gamesFormatedDate = new File("games_formated_release_data.csv");
        File sortedFile = new File("games_release_date_" + sortingMethod + ".csv");
    
        CSVParser csvParser = CSVCreate.createReader(gamesFormatedDate);
        CSVPrinter csvPrinter = CSVCreate.createWriter(sortedFile, csvParser);
    
        List<CSVRecord> records = csvParser.getRecords();
        int rows = records.size();
        
        int columns = 0;
        if (rows > 0) {
            columns = records.get(0).size();
        }
    
        String[][] dados = new String[rows][columns];
    
        for (int i = 0; i < rows; i++) {
            CSVRecord record = records.get(i);
            for (int j = 0; j < columns; j++) {
                dados[i][j] = record.get(j);
            }
        }

        String[][] dadosOrdenados;

        if("SelectionSort".equalsIgnoreCase(sortingMethod)){
            dadosOrdenados = SortingAlgorithms.selectionSort(dados, rows);
        }

        else if("InsertionSort".equalsIgnoreCase(sortingMethod)){
            dadosOrdenados = SortingAlgorithms.insertionSort(dados, rows);
        }

        else if("MergeSort".equalsIgnoreCase(sortingMethod)){
            dadosOrdenados = SortingAlgorithms.mergeSort(dados, rows);
        }
        
        else{
            throw new IllegalArgumentException("Método de ordenação inválido: " + sortingMethod);
        }
    
        for(String[] linha : dadosOrdenados){
            csvPrinter.printRecord((Object[]) linha);
        }
    
        csvPrinter.close();
        csvParser.close();

    }
    
    public static void createFiles(){
        try {

            //System.out.println("Generating 'games_release_date_SelectionSort.csv'");
            //generateCsvSorted("SelectionSort");
            //System.out.println("Done\n");

            System.out.println("Generating 'games_release_date_InsertionSort.csv'");
            generateCsvSorted("InsertionSort");
            System.out.println("Done\n");

            //System.out.println("Generating 'games_release_date_MergeSort.csv'");
            //generateCsvSorted("MergeSort"); //de 3 a 4 segundos
            //System.out.println("Done\n"); 

        } 
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
       
    }

}
