package com.engeto.homework.lekcePokojoveRostliny;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class PlantList {
    private List<Plant> plantList = new ArrayList<>();

    // region add, remove, getPlantFromIndex, sort, getPlantlist
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

    public void sortByName(){
        Collections.sort(plantList, new PlantNameCommparator());
    }



    public void sortByWatering(){
        Collections.sort(plantList, new PlantWateringComparator());
    }

    public List<Plant> getPlantList() {
        return new ArrayList<>(plantList);
    }

    public void getPlantDates(){
        Set<LocalDate> dates = new HashSet<>();
        for (Plant plant:plantList){
            dates.add(plant.getPlanted());
        }
        for (LocalDate date : dates) {
            System.out.println(date);
        }
    }
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
        catch (DateTimeParseException e) {
          throw new PlantException("Špatný formát datumu na řádku: " + lineNumber + "\n" + e.getLocalizedMessage());
        }
    }

    public void saveToFile(String filename) throws PlantException {
        try (PrintWriter outputWriter = new PrintWriter(new FileWriter(filename))) {
            for (Plant plant : plantList) {
                outputWriter.println(plant);
            }
        } catch (IOException e) {
            throw new PlantException("Došlo k chybě při zápisu do souboru "+filename+": "+e.getLocalizedMessage());
        }
    }
}
