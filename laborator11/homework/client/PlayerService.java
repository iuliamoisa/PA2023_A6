package com.example.lab11.client;
import com.example.lab11.models.Player;
import org.springframework.web.client.RestTemplate;
import java.util.List;
public class PlayerService {
    private final String BASE_URL = "http://localhost:8081/Players";
    private final RestTemplate restTemplate;

    public PlayerService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Player> getPlayers() {
        String url = "http://localhost:8081/Players/all";
        return restTemplate.getForObject(url, List.class);//getForEntity
    }

    public int countPlayers() {
        String url = "http://localhost:8081/Players/count";
        return restTemplate.getForObject(url, Integer.class);
    }

    public Player addPlayer(Player player) {
        String url = "http://localhost:8081/Players";
        return restTemplate.postForObject(url, player, Player.class);
    }

    public void updatePlayerName(int id, String newName) {
        String url = "http://localhost:8081/Players/{id}?newName={newName}";
        restTemplate.put(url, null, id, newName);
        System.out.println("Updated name.");
    }

    public void deletePlayer(int id) {
        String url = "http://localhost:8081/Players/{id}";
        restTemplate.delete(url, id);
        System.out.println("Player with ID " + id + " has been deleted successfully.");
    }
    public static void main(String[] args) {
        PlayerService PlayerService = new PlayerService();
        System.out.println("~~~ All players:\n"  + PlayerService.getPlayers());
        System.out.println("~~~ There are " + PlayerService.countPlayers() + " players.");

        Player newPlayer = new Player(7, "John");
        PlayerService.addPlayer(newPlayer);
        System.out.println("Added player: " + newPlayer);

        System.out.println("~~~ Updating name:");
        PlayerService.updatePlayerName(7, "Barbu");

        System.out.println("~~~ Deleting player...:");
        PlayerService.deletePlayer(7);
    }
}
