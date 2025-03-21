package com.faculdadeuepb.computacao.model.utils;

import java.util.Arrays;

public class SortingAlgorithms {

    public static String[][] selectionSort(String[][] dadosArray,int rows){

        for (int i = 0; i < rows-1; i++) {
            int minIndex = i;
            for (int j = i+1; j<rows; j++) {
                if (Date.checkDateSize(dadosArray[j][2], dadosArray[minIndex][2])) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                String[] temp = dadosArray[i];
                dadosArray[i] = dadosArray[minIndex];
                dadosArray[minIndex] = temp;
            }
        }

        return dadosArray;

    }

    public static String[][] insertionSort(String[][] dadosArray, int rows){
        for (int i = 1; i < rows; i++){
            String[] chave = dadosArray[i];
            int j = i - 1;

            while (j >= 0 && !Date.checkDateSize(dadosArray[j][2], chave[2])){
                dadosArray[j+1] = dadosArray[j]; 
                j = j-1;
            }
            dadosArray[j+1] = chave;  
        }
        
        return dadosArray;
    }

    public static String[][] mergeSort(String[][] dataArray, int rows) {
        if (rows <= 1) {
            return dataArray;
        }
        int middle = rows / 2;

        String[][] left = Arrays.copyOfRange(dataArray, 0, middle);
        String[][] right = Arrays.copyOfRange(dataArray, middle, rows);

        left = mergeSort(left, left.length);
        right = mergeSort(right, right.length);

        return merge(left, right);
    }

    private static String[][] merge(String[][] left, String[][] right) {

        int leftSize = left.length;
        int rightSize = right.length;
        String[][] result = new String[leftSize + rightSize][];
    
        int i = 0, j = 0, k = 0;
    
        while (i < leftSize && j < rightSize) {
            if (Date.checkDateSize(left[i][2], right[j][2])) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            result[k++] = left[i++];
        }
        while (j < rightSize) {
            result[k++] = right[j++];
        }
    
        return result;

    }
    
}
    
