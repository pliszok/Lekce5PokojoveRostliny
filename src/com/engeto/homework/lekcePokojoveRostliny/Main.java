package com.engeto.homework.lekcePokojoveRostliny;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static String OUTPUT_FILE = "outputFile.txt";

    public static void main(String[] args) throws PlantException{

        //dopln si try catch na jednotlive prikazy
        try {

            PlantList list = new PlantList();
            list.addAllFromFile(Settings.getFilename());

            Plant plantExample = new Plant("Kaktus", "není moc náročný",
                    180, LocalDate.of(2022, 1, 16), LocalDate.of(2021, 6, 28));
            Plant plantWithError = new Plant("Růže", "má trny",
                    5, LocalDate.of(2023, 3, 1), LocalDate.of(2022, 10, 16));

//        plantWithError.getWateringInfo();

            list.addPlant(plantExample);
            list.addPlant(plantWithError);
            System.out.println("===Ted jsem pridal dva objetky===");

            Collections.sort(list.getPlantList());

            for (Plant plant : list.getPlantList()) {
                System.out.println(plant);
            }

            list.removePlant(list.getPlantFromIndex(list.getPlantList(), 1));
            System.out.println("===Ted jsem ubral jeden objekt a seřadíme podle jména===");

            list.sortByName();

            for (Plant plant : list.getPlantList()) {
                System.out.println(plant);
            }


            Plant plantExample2 = new Plant("Lilie", "komentar po upravach",
                    14, LocalDate.of(2022, 4, 16), LocalDate.of(2021, 8, 28));
            list.addPlant(plantExample2);

            list.sortByWatering();

            list.saveToFile("outputFile.txt");

            System.out.println("=== Ted načítáme z námi uloženého souboru, seřazeno podle posledního zalévání===");

            list.addAllFromFile("outputFile.txt");
        }
        catch (Exception e){
            throw new PlantException(e.getLocalizedMessage());
        }
    }
}
