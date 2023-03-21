package com.engeto.homework.lekcePokojoveRostliny;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private List<Plant> plantList = new ArrayList<>();

    // region add, remove, getPlantFromIndex
    public void addPlant(Plant plant){
        plantList.add(plant);
    }

    public void removePlant(Plant plant){
        plantList.remove(plant);
    }

    public Plant getPlantFromIndex(List<Plant> plantList, int index)throws IndexOutOfBoundsException{
        if(index<0&&index> plantList.size()){
            throw new IndexOutOfBoundsException();  //("Musíš zadat index od \"0\" do "+plantList.size()+". Zadal jsi "+index);
        }
        return plantList.get(index);
    }

//    public String sortByName(List<String> plantList){
//        List<String> seznam = new ArrayList<>(plantList);
//        seznam.sort((Comparator<? super String>) plantList);
//        return  plantList.toString();

    //endregion


    public void addAllFromFile(String filename) throws PlantException {
        int lineNumber = 0;
        String[] items = new String[4];
        try
            //           File file = new File(filename);
                (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                items = line.split("\t");
                Plant plant = new Plant(items[0], items[1], new Integer(items[2]), LocalDate.parse(items[3]), LocalDate.parse(items[4]));
                plantList.add(plant);
                System.out.println(plant);
            }
        }
        catch (FileNotFoundException e){
            throw new PlantException("Soubor nenalezen. Error: "+e.getMessage());
        }
        catch (NumberFormatException e){
            throw new PlantException("Špatně zadané číslo na řádku: "+lineNumber+": \""+items[2]+"\" není číslo.");
        }
//        catch (DateFormatSymbols e) {
//          throw new PlantException("Špatný formát datumu na řádku: " + lineNumber + "\n" + items[3] +", "+items[4]+ ": " + e.getCalendar());
//        }
    }
    public List<Plant> getPlantList() {return new ArrayList<>(plantList);}
}
