package com.example.lab11.controllers;

import com.example.lab11.models.Player;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/Players")
public class PlayerController {
    private final List<Player> players = new ArrayList<>();

    public PlayerController() {
        players.add(new Player(1, "Ana"));
        players.add(new Player(2, "Andrei"));
        players.add(new Player(3, "Ioana"));
        players.add(new Player(4, "Mihai"));
        players.add(new Player(5, "Andreea"));
        players.add(new Player(6, "Stefan"));
    }

    @GetMapping("/all")
    public List<Player> getPlayers() {
        return players;
    }
    @GetMapping("/count")
    public int countPlayers() {
        return players.size();
    }
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return players.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }
    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        players.add(player);
        return player;
    }
    @PutMapping("/{id}")
    public Player updatePlayerName(@PathVariable int id, @RequestParam String newName) {
        for (Player player : players) {
            if (player.getId() == id) {
                player.setName(newName);
                return player;
            }
        }
        throw new IllegalArgumentException("Player not found with ID: " + id);
    }
    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable int id) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getId() == id) {
                iterator.remove();
                return "Player with ID " + id + " has been deleted successfully.";
            }
        }
        throw new IllegalArgumentException("Player not found with ID: " + id);
    }
}

