package com.example.lab11.client;

import com.example.lab11.models.Game;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class GameService {
    private final String BASE_URL = "http://localhost:8081/Games";
    private final RestTemplate restTemplate;
    public GameService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Game> getGames() {
        String url = "http://localhost:8081/Games/all";
        return restTemplate.getForObject(url, List.class);//getForEntity
    }
    public int countGames() {
        String url = "http://localhost:8081/Games/count";
        return restTemplate.getForObject(url, Integer.class);
    }
    public Game addGame(Game game) {
        String url = "http://localhost:8081/Games";
        return restTemplate.postForObject(url, game, Game.class);
    }

    public void updateGameName(int id, String newName) {
        String url = "http://localhost:8081/Games/{id}?newName={newName}";
        restTemplate.put(url, null, id, newName);
        System.out.println("Updated name.");
    }

    public void deleteGame(int id) {
        String url = "http://localhost:8081/Games/{id}";
        restTemplate.delete(url, id);
        System.out.println("Game with ID " + id + " has been deleted successfully.");
    }

    public static void main(String[] args) {
        GameService GameService = new GameService();
        System.out.println("~~~ All games:\n"  + GameService.getGames());
        System.out.println("~~~ There are " + GameService.countGames() + " games.");

        Game newGame = new Game(10, "G10");
        GameService.addGame(newGame);
        System.out.println("Added game: " + newGame);

        System.out.println("~~~ Updating name:");
        GameService.updateGameName(4, "Jocul 4");

        System.out.println("~~~ Deleting game...:");
        GameService.deleteGame(4);
        System.out.println("~~~ All games:\n"  + GameService.getGames());
    }
}
