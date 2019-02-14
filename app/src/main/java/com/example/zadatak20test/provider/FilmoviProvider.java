package com.example.zadatak20test.provider;

import com.example.zadatak20test.model.Filmovi;
import com.example.zadatak20test.model.Glumac;

import java.util.ArrayList;
import java.util.List;

public class FilmoviProvider {


    public static List<Filmovi> getFilmovi() {
        List<Filmovi> listaFilmova = new ArrayList<>();
        listaFilmova.add(new Filmovi(0,"Robin Hud 1994, Sherwood.", 6.5, "Robin Hud"));
        listaFilmova.add(new Filmovi(1,"RobinHud 2010", 8.0,"Robin Hud"));
        listaFilmova.add(new Filmovi(2,"RobinHud 2018",9.9,"Robin Hud"));
        listaFilmova.add(new Filmovi(3,"DeadPool 1",9.1,"Rajan Rejnolds"));
        listaFilmova.add(new Filmovi(4,"DeadPool 2",10.0,"Rajan Rejnolds"));
        listaFilmova.add(new Filmovi(5,"The Proposal",8.1,"Rajan Rejnolds" ));
        listaFilmova.add(new Filmovi(6, "Just Friends", 7.7,"Rajan Rejnolds"));
        listaFilmova.add(new Filmovi(7, "Legends of The Fall", 5.5, "Bred Pitt"));
        listaFilmova.add(new Filmovi(8,"Fury", 7.2, "Bred Pitt"));
        listaFilmova.add(new Filmovi(9, "Spy Game", 8.6,"Bred Pitt"));
        return listaFilmova;

    }

    public static List<String> getFilmoviNames() {
        List<String> filmoviImena = new ArrayList<>();
        for (Filmovi f: getFilmovi()) {
            filmoviImena.add(f.getImeFilma());
        }
        return filmoviImena;
    }

    public static List<String> getFilmoviToString1() {
        List<String> filmovi = new ArrayList<>();
        for (Filmovi f: getFilmovi()) {
            filmovi.add(f.toString1());
        }
        return filmovi;
    }



}
