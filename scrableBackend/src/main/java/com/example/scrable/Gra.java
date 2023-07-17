package com.example.scrable;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class Gra {

    private final Plansza plansza = new Plansza();
    private final WorekZPlytkami worekZPlytkami = new WorekZPlytkami();
    private List<Gracz> gracze = new ArrayList<>();
    private int aktualnyGracz;

    public void umiescSlowo(String slowo, int numerMiejscaNaPlanszy, boolean poziomo) {
        String noweSlowo = slowo.toUpperCase();
        Gracz gracz = gracze.get(aktualnyGracz);
        if (!sprawdzPoprawnoscRuchu(numerMiejscaNaPlanszy, noweSlowo)) {
            throw new RuntimeException("Nieprawidłowy ruch!");
        }
        int a = numerMiejscaNaPlanszy;
        for (int i = 0; i < slowo.length(); i++) {
            char litera = noweSlowo.charAt(i);
            if (!gracz.sprawdzCzyGraczMaLitere(litera)) {
                if (litera != plansza.getPola(a)) {
                    throw new RuntimeException("Nie posiadasz litery: " + litera);
                }
            }
            if (poziomo) a++;
            else a += 15;
        }

        if (poziomo) {
            for (int i = 0; i < noweSlowo.length(); i++) {
                char litera = noweSlowo.toUpperCase().charAt(i);
                plansza.getPola().set(numerMiejscaNaPlanszy++, litera);
                try {
                    gracz.getPlytki().remove(gracz.getPlytka(noweSlowo.charAt(i)));
                } catch (Exception e) {
                }

            }
        } else {
            for (int i = 0; i < noweSlowo.length(); i++) {
                char litera = noweSlowo.toUpperCase().charAt(i);
                plansza.getPola().set(numerMiejscaNaPlanszy, litera);
                try {
                    gracz.getPlytki().remove(gracz.getPlytka(noweSlowo.charAt(i)));
                } catch (Exception e) {
                }
                numerMiejscaNaPlanszy += 15;
            }
        }
        int brakujaceLitery = 7 - gracz.getPlytki().size();
        dodajPlytki(gracz, brakujaceLitery);
        aktualnyGracz = (aktualnyGracz + 1) % gracze.size();
    }
    public void wymienLitery(String name, String litery) {
        String noweLitery = litery.toUpperCase();
        Gracz gracz = getGracz(name);
        for (char c : noweLitery.toCharArray()) {
            if (gracz.sprawdzCzyGraczMaLitere(c)) {
                wylosujPlytke(gracz);
                gracz.getPlytki().remove(gracz.getPlytka(c));
            }
        }
    }

    public void dodajGracza(String nazwa) {
        Gracz gracz = new Gracz(nazwa);
        dodajPlytki(gracz, 7);
        gracze.add(gracz);
    }

    private void dodajPlytki(Gracz gracz, int iloscPlytke) {
        for (int i = 0; i < iloscPlytke; i++) {
            wylosujPlytke(gracz);
        }
    }

    private Plytka wylosujPlytke(Gracz gracz) {
        Random random = new Random();
        int index = random.nextInt(worekZPlytkami.getWorek().size());
        gracz.dodajPlytke(worekZPlytkami.getPlytka(index));
        return worekZPlytkami.getWorek().remove(index);
    }
    private boolean sprawdzPoprawnoscRuchu(int index, String slowo) {
        if (slowo.length() == 0) {
            return false;
        }
        if (index > 254) {
            return false;
        }
        if (index < 0) {
            return false;
        }
        return true;
    }
    public Gracz getGracz(String nazwa) {
        return gracze.stream()
                .filter(c -> c.getNazwa().equals(nazwa))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono gracza o nazwie: " + nazwa));
    }

    public Plansza getPlansza() {
        return plansza;
    }

    public WorekZPlytkami getWorekZPlytkami() {
        return worekZPlytkami;
    }

    public int getAktualnyGracz() {
        return aktualnyGracz;
    }
}
