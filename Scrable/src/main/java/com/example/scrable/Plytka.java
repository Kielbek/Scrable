package com.example.scrable;

public class Plytka {
    private final char litera;
    private final int wartoscPunktowa;

    public Plytka(char litera, int wartoscPunktowa) {
        this.litera = litera;
        this.wartoscPunktowa = wartoscPunktowa;
    }

    public char getLitera() {
        return litera;
    }

    public int getWartoscPunktowa() {
        return wartoscPunktowa;
    }

    @Override
    public String toString() {
        return "" + litera;
    }
}
