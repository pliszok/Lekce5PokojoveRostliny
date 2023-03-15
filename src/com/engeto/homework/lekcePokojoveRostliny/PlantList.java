package com.engeto.homework.lekcePokojoveRostliny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private List<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant plant){
        plantList.add(plant);
    }

    public void removePlant(Plant plant){
        plantList.remove(plant);
    }

    public Plant getPlantFromIndex(List<Plant> plantList, int index)throws IndexOutOfBoundsException{
        if(index<0&&index> plantList.size()){
            throw new IndexOutOfBoundsException("Musíš zadat index od \"0\" do "+plantList.size()+". Zadal jsi "+index);
        }
        return plantList.get(index);
    }

    public void addAllFromFile(String filename) {
        try {
            int lineNumber = 0;
            String[] items = new String[4];
            File file = new File(filename);
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
            {
                while (scanner.hasNextLine()) {
                    lineNumber++;
                    String line = scanner.nextLine();
                    items = line.split("\t");
                    Plant plant = new Plant(items[0], items[1], LocalDate.parse(items[4]), LocalDate.parse(items[3]), Integer.parseInt(items[2]));
                    plantList.add(plant);
                    System.out.println(plant);
                }
            }
        }
        catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
    public List<Plant> getPlantList() {return new ArrayList<>(plantList);}
}
