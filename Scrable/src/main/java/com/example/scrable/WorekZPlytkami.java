package com.example.scrable;

import java.util.ArrayList;
import java.util.List;

public class WorekZPlytkami {
    private List<Plytka> worek;

    public WorekZPlytkami() {
        worek = new ArrayList<>();
        dodajLiteryDoWorka();
    }

    private void dodajLiteryDoWorka() {
        int[] wartosciPunktowe = {
                0,
                1, 1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2,
                3, 3, 3, 3, 3, 3,
                5, 5, 5, 5, 5, 5,
                6,
                7,
                9
        };

        int[] ilosciWystapien = {
                2,
                9, 8, 7, 6, 5, 5, 4, 4, 4,
                4, 3, 3, 3, 3, 3, 3, 3,
                2, 2, 2, 2, 2, 2,
                1, 1, 1, 1, 1, 1,
                1,
                1,
                1
        };

        // Litery A-Z (polska wersja Scrabble)
        char[] litery = {
                ' ',
                'A', 'I', 'E', '0', 'N', 'Z', 'R', 'S', 'W',
                'Y', 'C', 'D', 'K', 'L', 'M', 'P', 'T',
                'B', 'G', 'H', 'J', 'Ł', 'U',
                'Ą', 'Ę', 'F', 'Ó', 'Ś', 'Z',
                'Ć',
                'Ń',
                'Ź'
        };

        for (int i = 0; i < litery.length; i++) {
            char litera = litery[i];
            int wartoscPunktowa = wartosciPunktowe[i];
            int iloscWystapien = ilosciWystapien[i];

            for (int j = 0; j < iloscWystapien; j++) {
                Plytka plytka = new Plytka(litera, wartoscPunktowa);
                worek.add(plytka);
            }
        }
    }

    public List<Plytka> getWorek() {
        return worek;
    }

    public Plytka getPlytka(int numerPlytk) {
        return worek.get(numerPlytk);
    }
}
