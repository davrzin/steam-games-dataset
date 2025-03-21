package com.faculdadeuepb.computacao.application;

import java.io.IOException;

import com.faculdadeuepb.computacao.model.utils.Ordination;
import com.faculdadeuepb.computacao.model.utils.Transformations;

public class Program {

    public static double convertNanoToSeconds(long nanoseconds) {
        return nanoseconds / 1_000_000_000.0;
    }
    
    public static void main(String[] args) throws IOException{

        long startTime = System.nanoTime();

        Transformations.createFiles();
        
        Ordination.createFiles();

        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        
        System.out.println("Tempo de execução: " + convertNanoToSeconds(duration) + " segundos");

    }
}
