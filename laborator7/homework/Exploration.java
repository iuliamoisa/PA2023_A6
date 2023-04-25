package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private static ListeningCommand command;
    private final SharedMemory mem = new SharedMemory(5);
    private final ExplorationMap map = new ExplorationMap();
    private final List<Robot> robots = new ArrayList<>();

    public void start() {//start a new Thread representing the robot;
        command.start();
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
//        System.out.println(map);
    }
    public void addRobot(Robot robot){
        robots.add(robot);
    }

    public static void main(String[] args) {
        var explore = new Exploration();
        command = new ListeningCommand(explore);
        explore.addRobot(new Robot("Wall-E", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));
        Timekeeper timeKeeper = new Timekeeper(90000, explore);
        Thread timer = new Thread(timeKeeper);
        timer.setDaemon(true);
        timer.start();
        explore.start();
    }

    public ExplorationMap getMap() {
        return map;
    }

    public SharedMemory getMem() {
        return mem;
    }

    public List<Robot> getRobots() {
        return robots;
    }
}
