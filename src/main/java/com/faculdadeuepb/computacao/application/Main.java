package com.faculdadeuepb.computacao.application;

import java.io.File;

import com.faculdadeuepb.computacao.model.entities.Transformations;

public class Main {
        
    public static void main(String[] args){

        System.out.println("Generating file called 'games_formated_release_data.csv'");
        Transformations.transformDateFormat(new File("games.csv"));
        System.out.println("Done\n");
        
        System.out.println("Generating file called 'games_linux.csv'");
        Transformations.transformSupportLinux(new File("games_formated_release_data.csv"));
        System.out.println("Done\n");
        
    }
}