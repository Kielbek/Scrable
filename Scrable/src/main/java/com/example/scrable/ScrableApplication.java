package com.example.scrable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScrableApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ScrableApplication.class, args);
        Gra gra = new Gra();
        Gracz gracz1 = new Gracz();
        Gracz gracz2 = new Gracz();
        Gracz gracz3 = new Gracz();
        Gracz gracz4 = new Gracz();
        gra.rozpocznijGre(gracz1, gracz2, gracz3, gracz4);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(gracz1.getPlytki());
            String slowo = scanner.nextLine();
            gra.umiescSlowo(gracz1, slowo, 1, true);
            gra.getPlansza().wyswietlPlansze();
        }


    }

}
