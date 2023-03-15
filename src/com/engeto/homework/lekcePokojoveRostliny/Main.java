package com.engeto.homework.lekcePokojoveRostliny;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try{
        PlantList list = new PlantList();
        list.addAllFromFile(Settings.getFilename());

        Plant plantExample = new Plant("Kaktus", "není moc náročný",
                LocalDate.of(2022, 06, 28), LocalDate.of(2023, 1, 16), 180);
        Plant plantWithError = new Plant("Růže", "má trny",
                LocalDate.of(2023, 1, 31), LocalDate.of(2023, 3, 1), -5);

        list.addPlant(plantExample);
        list.addPlant(plantWithError);
//      System.out.println("pridani objektu: "+list.getPlantList());

        for (Plant plant: list.getPlantList()) {
            System.out.println(plant);
            System.out.println(" ");
        }

        list.removePlant(list.getPlantFromIndex(list.getPlantList(),2));
//        list.getPlantFromIndex(List<PlantList>list, 2);

            for (Plant plant: list.getPlantList()) {
                System.out.println(plant);
                System.out.println(" ");
            }

        System.out.println(plantExample.getWateringInfo());
        System.out.println(plantWithError.getWateringInfo());
    }
        catch (PlantException ex){
            System.err.println("Chyba: " + ex.getMessage());
        }
    }
}
