package com.engeto.homework.lekcePokojoveRostliny;

import java.util.Comparator;

public class PlantNameCommparator implements Comparator<Plant> {
    @Override
    public int compare(Plant o1, Plant o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
