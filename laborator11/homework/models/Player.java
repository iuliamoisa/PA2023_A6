package com.example.lab11.models;
public class Player {
    private int id;
    private String name;
    public Player() {
        // Default constructor required for JSON deserialization
    }
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                '}' + "\n";
    }
}
