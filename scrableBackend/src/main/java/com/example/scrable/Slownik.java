package com.example.scrable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Slownik {
    private List<String> slownik;

    public Slownik(String sciezkaDoPliku) {
        slownik = new ArrayList<>();
        wczytajSlownik(sciezkaDoPliku);
    }

    private void wczytajSlownik(String sciezkaDoPliku) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sciezkaDoPliku))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                slownik.add(linia.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean sprawdzCzySlowoWSlowniku(String slowo) {
        return slownik.contains(slowo);
    }

    public List<String> getSlownik() {
        return slownik;
    }
}


