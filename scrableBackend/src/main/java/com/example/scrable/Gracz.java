package com.example.scrable;

import java.util.ArrayList;
import java.util.List;

public class Gracz {
    private String nazwa;
    private List<Plytka> plytki;
    private int liczbaaPunktow;

    public Gracz(String nazwa) {
        this.nazwa = nazwa;
        plytki = new ArrayList<>();
        liczbaaPunktow = 0;
    }

    public void dodajPlytke(Plytka plytka) {
        plytki.add(plytka);
    }
    public List<Plytka> getPlytki() {
        return plytki;
    }

    public int getLiczbaaPunktow() {
        return liczbaaPunktow;
    }

    public void setLiczbaaPunktow(int liczbaaPunktow) {
        this.liczbaaPunktow = liczbaaPunktow;
    }

    public boolean sprawdzCzyGraczMaLitere(char litera) {
        for (Plytka c : plytki) {
            if (c.getLitera() == litera) {
                return true;
            }
        }
        return false;
    }

    public Plytka getPlytka(char litera) {
        for (Plytka c : plytki) {
            if (c.getLitera() == litera) {
                return c;
            }
        }
        throw new RuntimeException("Nie znaleziono plytki!");
    }

    public String getNazwa() {
        return nazwa;
    }
}
