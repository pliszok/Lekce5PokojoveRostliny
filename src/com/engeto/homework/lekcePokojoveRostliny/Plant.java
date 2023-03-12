package com.engeto.homework.lekcePokojoveRostliny;

import java.time.LocalDate;

public class Plant {
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

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
        //Proč nefunguje throws PlantException atd. jako na řádku 78-81 tady?
    }
    //endregion

    //region constructors
    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }
    public Plant(String name, LocalDate planted, int frequencyOfWatering) {
        this.name = name;
        this.notes = " ";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;
    }
    public Plant(String name) {
        this(name, " ", LocalDate.now(), LocalDate.now(), 7);
    }
    //endregion

    //region methods
    public String getWateringInfo() throws PlantException{
        if(frequencyOfWatering<=0) {
            throw new PlantException("The frequency of watering cannot be \"zero\" or negative and you have entered: " + frequencyOfWatering +".");
        }
            return getName() + ", last watered on: " + getWatering() + ", next watering is on: " + (watering.plusDays(frequencyOfWatering));
    }
    //endregion
}
