package com.example.scrable;

import java.util.Random;

public class Gra {

    private final Plansza plansza = new Plansza();
    private final WorekZPlytkami worekZPlytkami = new WorekZPlytkami();

    public void umiescSlowo(Gracz gracz, String slowo, int numerMiejscaNaPlanszy, boolean poziomo) {
        if (poziomo) {
            for (int i = 0; i < slowo.length(); i++) {
                if (gracz.sprawdzCzyGraczMaLitere(slowo.charAt(i)) && sprawdzPoprawnoscKolumny(slowo.charAt(i), plansza.getPola(numerMiejscaNaPlanszy))) {
                    String litera = Character.toString(slowo.charAt(i)).toUpperCase();
                    plansza.getPola().set(numerMiejscaNaPlanszy++, litera + "    ");
                    gracz.getPlytki().remove(gracz.getPlytka(slowo.charAt(i)));
                }
            }
        } else {
            for (int i = 0; i < slowo.length(); i++) {
                if (gracz.sprawdzCzyGraczMaLitere(slowo.charAt(i)) && sprawdzPoprawnoscKolumny(slowo.charAt(i), plansza.getPola(numerMiejscaNaPlanszy))) {
                    String litera = Character.toString(slowo.charAt(i)).toUpperCase();
                    plansza.getPola().set(numerMiejscaNaPlanszy, litera + "    ");
                    gracz.getPlytki().remove(gracz.getPlytka(slowo.charAt(i)));
                    numerMiejscaNaPlanszy += 15;
                }
            }
        }
    }

    public void rozpocznijGre(Gracz gracz1, Gracz gracz2, Gracz gracz3, Gracz gracz4) {
        rozloujKupke(gracz1);
        rozloujKupke(gracz2);
        rozloujKupke(gracz3);
        rozloujKupke(gracz4);
    }

    private void rozloujKupke(Gracz gracz) {
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int index = random.nextInt(worekZPlytkami.getWorek().size());
            gracz.dodajPlytke(worekZPlytkami.getPlytka(index));
            worekZPlytkami.getWorek().remove(index);
        }
    }
    private boolean sprawdzPoprawnoscKolumny(char literaSlowa, String literaZPlanszy) {
        try {
            if (Integer.parseInt(literaZPlanszy.trim()) < 255) return true;
        }
        catch (Exception e) {
            return literaSlowa == literaZPlanszy.charAt(0);
        }
        return literaSlowa == literaZPlanszy.charAt(0);
    }

    public Plansza getPlansza() {
        return plansza;
    }
}
