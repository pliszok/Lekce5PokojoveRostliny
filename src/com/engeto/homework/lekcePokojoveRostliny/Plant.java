package com.engeto.homework.lekcePokojoveRostliny;

import java.time.LocalDate;
import java.util.*;

public class Plant implements Comparable<Plant>{
    //region atributes
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;
    //endregion

    //region getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException{
        if (watering.isBefore(planted)) {
            throw new PlantException("The last watering date was set before the date of planting. " +
                    "Planted on: " + planted + ", next watering on: " + watering + ".");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException{
        if (frequencyOfWatering <= 0) {
            throw new PlantException("The frequency of watering cannot be \"zero\" or negative and you have entered: " + frequencyOfWatering + ".");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }
    //endregion

    //region constructors
    public Plant(String name, String notes, int frequencyOfWatering, LocalDate watering, LocalDate planted) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
 //       System.out.println("pokus");
    }

    @Override
    public String toString() {
//        return "Jméno: "+name+", poznámka: "+notes+", zasazena: "+planted+", naposledy zalévaná: "+watering+", kolikrát týdně zalévat: "+frequencyOfWatering;
        return name+"\t"+notes+"\t"+frequencyOfWatering+"\t"+watering+"\t"+planted;

    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) throws PlantException{
        this.name = name;
        this.notes = " ";
        this.planted = planted;
        setWatering(LocalDate.now());
        setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant(String name) {
        this(name, " ", 7, LocalDate.now(), LocalDate.now());
    }
    //endregion

    //region methods
    public String getWateringInfo() throws PlantException {
        if (watering.isBefore(planted)) {
            throw new PlantException("Poslední zalévání bylo nastaveno před datem zasazení. " +
                    "Zasazeno: " + planted + ", příští zalévání: " + watering + ".");
        }
        if (frequencyOfWatering <= 0) {
            throw new PlantException("Četnost zalévání nemůže být \"nula\" nebo negativní. Zadal jsi " + frequencyOfWatering + ".");
        }
        return getName() + ", naposledy zalévána: " + getWatering() + ", příští zalévání: " + (watering.plusDays(frequencyOfWatering));
    }

    @Override
    public int compareTo(Plant plant) {
        return plant.getName().compareTo(plant.getName());
    }
    //endregion

}
