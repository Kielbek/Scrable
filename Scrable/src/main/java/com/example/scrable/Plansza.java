package com.example.scrable;

import java.util.ArrayList;
import java.util.List;

public class Plansza {
    private List<String> pola;

    public Plansza() {
        pola = new ArrayList<>();
        inicjalizujPola();
    }

    private void inicjalizujPola() {
        for (int i = 0; i < 225; i++) {
            if (i < 10) pola.add(i + "    ");
            else if (i < 100) pola.add(i + "   ");
            else  pola.add(i + "  ");
        }
    }

    public String getPola(int indexPola) {
        return pola.get(indexPola);
    }

    public List<String> getPola() {
        return pola;
    }

    public void wyswietlPlansze() {
        for (int i = 0; i < 225; i++) {
            if (i % 15 == 0) System.out.print("\n");
            System.out.print(pola.get(i));
        }
    }

//    public String getStanPlanszy() {
//        StringBuilder stanPlanszy = new StringBuilder();
//        for (int i = 0; i < 15; i++) {
//            for (int j = 0; j < 15; j++) {
//                stanPlanszy.append(pola[i][j]);
//                stanPlanszy.append(" ");
//            }
//            stanPlanszy.append("\n");
//        }
//        return stanPlanszy.toString();
//    }
}
