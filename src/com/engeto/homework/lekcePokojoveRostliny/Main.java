package com.engeto.homework.lekcePokojoveRostliny;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String OUTPUT_FILE = "outputFile.txt";

    public static void main(String[] args) throws PlantException{

        PlantList list = new PlantList();
        list.addAllFromFile(Settings.getFilename());

        Plant plantExample = new Plant("Kaktus", "není moc náročný",
              180, LocalDate.of(2022, 1, 16), LocalDate.of(2021,6,28));
        Plant plantWithError = new Plant("Růže", "má trny",
                5, LocalDate.of(2023, 3, 1), LocalDate.of(2022,10,16));

//        plantWithError.getWateringInfo();

        list.addPlant(plantExample);
        list.addPlant(plantWithError);
        System.out.println("---");
        System.out.println("Ted jsem pridal dva objetky");
        System.out.println("---");

        for (Plant plant: list.getPlantList()) {
            System.out.println(plant);
        }

        list.removePlant(list.getPlantFromIndex(list.getPlantList(),1));
        System.out.println("---");
        System.out.println("Ted jsem ubral jeden objekt");
        System.out.println("---");

        for (Plant plant: list.getPlantList()) {
            System.out.println(plant);
        }


        Plant plantExample2 = new Plant("Lilie", "komentar",
                14, LocalDate.of(2022, 4, 16), LocalDate.of(2021,8,28));
        list.addPlant(plantExample2);

//        list.sortByName((List<String>) list);

        try (PrintWriter outputWriter = new PrintWriter(new FileWriter(OUTPUT_FILE))){
            for(Plant plant: list.getPlantList()){
                outputWriter.println(plant);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        list.addAllFromFile("outputFile.txt");

        //Plant pokusna = new Plant("pokusna");

//        for (Plant plant : list1.getPlantList()) {
//            System.out.println(plant);
//        }
    }
}
