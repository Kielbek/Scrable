package com.example.scrable;

import java.util.ArrayList;
import java.util.List;

public class Plansza {
    private List<Character> pola;

    public Plansza() {
        pola = new ArrayList<>();
        inicjalizujPola();
    }

    private void inicjalizujPola() {
        for (int i = 0; i < 225; i++) {
            pola.add(' ');
        }
    }

    public char getPola(int indexPola) {
        return pola.get(indexPola);
    }

    public List<Character> getPola() {
        return pola;
    }

    public void wyswietlPlansze() {
        for (int i = 0; i < 225; i++) {
            if (i % 15 == 0) System.out.print("\n");
            System.out.print(pola.get(i));
        }
    }

    public String getStanPlanszy() {
        StringBuilder stanPlanszy = new StringBuilder();
        for (int i = 0; i < 225; i++) {
            if (i % 15 == 0) {
                stanPlanszy.append("\n");
            }
            if (pola.get(i) != ' '){
                stanPlanszy.append(pola.get(i) + "   ");
            }
            else {
                if (i < 10) stanPlanszy.append(i + "   ");
                else if (i < 100) stanPlanszy.append(i + "  ");
                else stanPlanszy.append(i + " ");
            }
        }
        return stanPlanszy.toString();
    }
}
