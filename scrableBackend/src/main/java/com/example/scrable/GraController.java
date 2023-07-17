package com.example.scrable;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class GraController {
    HashMap<Integer, Gra> rooms = new HashMap<>();
    Slownik slownik = new Slownik("C:\\byle co\\Scrable\\src\\main\\resources\\slownik.txt");


    @PostMapping("/create-game/{name}")
    public void createGame(@PathVariable String name) {
        int roomdId = 123;
        rooms.put(roomdId, new Gra());
        rooms.get(roomdId).dodajGracza(name);
    }

    @PutMapping("/add-player/{roomId}/{name}")
    public void addPlayer(@PathVariable int roomId, @PathVariable String name) {
        rooms.get(roomId).dodajGracza(name);
    }

    @GetMapping("/get-board/{roomId}")
    public List<Character> getBoard(@PathVariable int roomId) {
        rooms.get(roomId).getPlansza().wyswietlPlansze();
        return rooms.get(roomId).getPlansza().getPola();
    }

    @PostMapping("add-word/{roomId}/{word}/{part}/{poziom}")
    public void addWord(@PathVariable int roomId, @PathVariable String word,
                        @PathVariable int part, @PathVariable boolean poziom) {

//        if (!slownik.sprawdzCzySlowoWSlowniku(word)) {
//            throw new RuntimeException("Złe słowo!");
//        }
        rooms.get(roomId).umiescSlowo(word, part, poziom);
    }

    @GetMapping("/user-plate/{roomId}/{name}")
    public List<Plytka> getUserPlate(@PathVariable int roomId, @PathVariable String name) {
        return rooms.get(roomId).getGracz(name).getPlytki();
    }

    @PutMapping("/change-letters/{roomId}/{name}/{letters}")
    public void changeLeters(@PathVariable int roomId, @PathVariable String name,
                             @PathVariable String letters) {
        rooms.get(roomId).wymienLitery(name, letters);
    }


}
