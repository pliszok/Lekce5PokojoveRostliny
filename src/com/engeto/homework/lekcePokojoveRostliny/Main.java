package com.engeto.homework.lekcePokojoveRostliny;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Plant plantExample = new Plant("Kaktus", "není moc náročný",
                LocalDate.of(2008, 06, 28), LocalDate.of(2022, 10, 16), 180);
        Plant plantWithError = new Plant("růže", "má trny",
                LocalDate.of(2023, 1, 31), LocalDate.of(2023, 3, 1), -4);

        try{
        System.out.println(plantExample.getWateringInfo());
        System.out.println(plantWithError.getWateringInfo());
    }
    catch (PlantException ex){
        System.err.println("The fraquency of watering error. " + ex.getMessage());
    }
    }
}
