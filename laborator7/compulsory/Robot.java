package org.example;

import java.util.Random;

public class Robot implements Runnable{
    private String name;
    private boolean running = true;
    Exploration explore;
    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
    }

    public void run() {
        while (running) {
            //pick a new cell to explore
            Random r1 = new Random();
            int row = r1.nextInt(4);
            Random r2 = new Random();
            int column = r2.nextInt(4);
            if(explore.getMap().visit(row, column, this) == false)
                running = false;
        }
    }

    public String getName() {
        return name;
    }

    public Exploration getExplore() {
        return explore;
    }
}
