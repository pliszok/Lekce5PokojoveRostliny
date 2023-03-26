package com.engeto.homework.lekcePokojoveRostliny;

import java.util.Comparator;

public class PlantWateringComparator implements Comparator<Plant> {

    public int compare(Plant plant1, Plant plant2){
        return plant1.getWatering().compareTo(plant2.getWatering());
    }

}
