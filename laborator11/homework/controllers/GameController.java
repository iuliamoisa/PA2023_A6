package com.example.lab11.controllers;

import com.example.lab11.models.Game;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/Games")
public class GameController {
    private List<Game> games = new ArrayList<>();
    public GameController() {
        games.add(new Game(1, "G1"));
        games.add(new Game(2, "G2"));
        games.add(new Game(3, "G3"));
        games.add(new Game(4, "G4"));
    }

    @GetMapping("/all")
    public List<Game> getGames() {
        return games;
    }
    @GetMapping("/count")
    public int countPlayers() {
        return games.size();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") int id) {
        // Find the game with the given ID in the list of games
        return games.stream()
                .filter(game -> game.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @PostMapping
    public Game addGame(@RequestBody Game game) {
        games.add(game);
        return game;
    }

    @PutMapping("/{id}")
    public Game updateGameName(@PathVariable int id, @RequestParam String newName) {
        for (Game game : games) {
            if (game.getId() == id) {
                game.setName(newName);
                return game;
            }
        }
        throw new IllegalArgumentException("Game not found with ID: " + id);
    }

    @DeleteMapping("/{id}")
    public String deleteGame(@PathVariable int id) {
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game game = iterator.next();
            if (game.getId() == id) {
                iterator.remove();
                return "Game with ID " + id + " has been deleted successfully.";
            }
        }
        throw new IllegalArgumentException("Game not found with ID: " + id);
    }
}
