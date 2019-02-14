package com.example.zadatak20test.provider;

import com.example.zadatak20test.model.Filmovi;
import com.example.zadatak20test.model.Glumac;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GlumacProvider {



    public static List<Filmovi> filmoviRobinHud() {
        List<Filmovi> listaRobinHud = new ArrayList<>();
        listaRobinHud.add(new Filmovi(0,"Robin Hud 1994, Sherwood.", 6.5, "Robin Hud"));
        listaRobinHud.add(new Filmovi(1,"RobinHud 2010", 8.0,"Robin Hud"));
        listaRobinHud.add(new Filmovi(2,"RobinHud 2018",9.9,"Robin Hud"));


        return listaRobinHud;

    }

    public static List<Filmovi> filmoviRajanRejnolds() {
        List<Filmovi> listaDeadPool = new ArrayList<>();
        listaDeadPool.add(new Filmovi(0,"DeadPool 1",9.1,"Rajan Rejnolds"));
        listaDeadPool.add(new Filmovi(1,"DeadPool 2",10.0,"Rajan Rejnolds"));
        listaDeadPool.add(new Filmovi(2,"The Proposal",8.1,"Rajan Rejnolds" ));
        listaDeadPool.add(new Filmovi(3, "Just Friends", 7.7,"Rajan Rejnolds"));
        return listaDeadPool;
    }

    public static List<Filmovi> filmoviBred() {
        List<Filmovi> listaBred = new ArrayList<>();
        listaBred.add(new Filmovi(0, "Legends of The Fall", 5.5, "Bred Pitt"));
        listaBred.add(new Filmovi(1,"Fury", 7.2, "Bred Pitt"));
        listaBred.add(new Filmovi(2, "Spy Game", 8.6,"Bred Pitt"));
        return listaBred;
    }




    // podesiti u filmovi da prima listu.


    public static List<Glumac> getGlumci() {


    List<Glumac> listaGlumaca = new ArrayList<>();
    listaGlumaca.add(new Glumac(0,"Rajan","Rejnolds","Takođe poznat kao \"Brbljivi plaćenik,\" Dedpul je poznat po svojoj pričljivoj prirodi i sklonosti da \"razbije četvrti zid\" , koji je koriščen od strane pisaca radi humorističkog efekta.","deadpool.jpg",7.7,new Date(),new Date(), filmoviRajanRejnolds()));
    listaGlumaca.add(new Glumac(1,"Robin","Hud","Robin Hud od svojih neprijatelja uzima novac i daje ga sirotinji ili ga vraća ukoliko im je prethodno pod nekim izgovorom uzet.","robinHud.jpg",8.9,new Date(),new Date(),filmoviRobinHud()));
    listaGlumaca.add(new Glumac(2,"Brad","Pitt","Bred Pit je slavni glumac iz Holivuda koji iza sebe ima bogatu karijeru sa velikim brojem filmova od kojih retko koji nije imao veliku zaradu. Bred je snimio velik broj filmova za koje je nagrađivan na brojnim festivalima ne samo u Americi nego i u Evropi.", "bredpit.jpg",9.5,new Date(),new Date(), filmoviBred()));
    return listaGlumaca;
    }

    public static List<String> getGlumciNames() {
        List<String> listaImena = new ArrayList<>();
        for (Glumac g: getGlumci()) {
            listaImena.add(g.getIme() + " " + g.getPrezime());

        }
        return listaImena;
    }

    public static Glumac getGlumciByName(String ime) {

            for (Glumac g: getGlumci()) {
                if (g.getIme().equalsIgnoreCase(ime)) {
                    return g;
                }
            }
            return null;
    }

    public static List<String> getGlumacNameById(int id) {
        List<String> listaImena = new ArrayList<>();
        for (Glumac g: getGlumci()) {
            if (g.getId() == id) {
               listaImena.add(g.getIme() + " " + g.getPrezime());

            }
        }
        return listaImena;
    }

   public static List<Filmovi> getFilmByGlumacId(int id) {

        for (Glumac g: getGlumci()) {
            if (g.getId() == id) {
                return g.getFilmovi();
            }
        }
        return null;
   }

   public static Glumac getCeoGlumacById(int id) {

        for (Glumac g: getGlumci()) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
   }


}
