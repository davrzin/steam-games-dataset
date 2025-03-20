package com.faculdadeuepb.computacao.model.entities;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class OrdinationSelectionSort {

    public static int[] countLinesColumnsCsv(File file){

        CSVParser csvParser = CSVCreate.createReader(file);

        int[] resultados = new int[2];
        int linhas = 0;
        int colunas = 0;
        CSVRecord lastRecord = null;
        
        for (CSVRecord record : csvParser){
            linhas++;
            lastRecord = record;  
        }      
        if(lastRecord != null)
            colunas = lastRecord.size();

        resultados[0] = linhas;
        resultados[1] = colunas;

        return resultados;
    }

    public static String[][] conversationToArray(){

        File file = new File("games_formated_release_data.csv");

        int[] linhasColunas = countLinesColumnsCsv(file);
        String[][] dados = new String[linhasColunas[0]][linhasColunas[1]];

        CSVParser csvParser = CSVCreate.createReader(file);
        
        int i = 0;   
        for (CSVRecord record : csvParser){
            for (int j = 0; j < record.size(); j++){
                dados[i][j] = record.get(j);
            }
            i++;
        }      
            
        return dados;
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

    public static String[][] SelectionSort(String[][] dadosArray){

        int rows = dadosArray.length;
        System.out.println(rows);

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
                System.out.println("Alteração feita");
            }
            System.out.println("Linha" + i);
        }

        return dadosArray;

    }

    public static void ordenandoSelectionSort(){

        String[][] arrayDados = conversationToArray();

        arrayDados = SelectionSort(arrayDados);

        System.out.println(arrayDados[0][2]);

    }

}
