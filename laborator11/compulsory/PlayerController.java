package com.example.lab11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
}

