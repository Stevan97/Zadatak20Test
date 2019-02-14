package com.example.zadatak20test.model;

import java.util.ArrayList;

public class Filmovi {

    private int id;
    private String imeFilma;
    private double ocenaFilma;
    private String mainActor;

    public Filmovi(int id,String imeFilma, double ocenaFilma,String mainActor) {
        this.id = id;
        this.imeFilma = imeFilma;
        this.ocenaFilma = ocenaFilma;
        this.mainActor = mainActor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImeFilma() {
        return imeFilma;
    }

    public void setImeFilma(String imeFilma) {
        this.imeFilma = imeFilma;
    }

    public double getOcenaFilma() {
        return ocenaFilma;
    }

    public void setOcenaFilma(double ocenaFilma) {
        this.ocenaFilma = ocenaFilma;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    @Override
    public String toString() {
       String text;
       text =  imeFilma + "\n" + "Ocena filma: " + ocenaFilma;
       return text;
    }

    public String toString1() {
        String text;
        text =  imeFilma + "\n" + "Ocena filma: " + ocenaFilma + "\n" + "Glavni Glumac: " + mainActor;
        return text;
    }


    // stavi da ima TextView koji pise "Glumio u Filmovima:" i onda ispod lista filmova koja samo primaju ime i ocenu.
}
