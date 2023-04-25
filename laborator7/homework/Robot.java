package org.example;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Robot implements Runnable{
    private String name;
    private boolean running = true;
    private boolean stopped = false;
    private boolean interrupted = false;
    Exploration explore;
    int nrOfTokens = 0;
    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
    }

    public void run() {
        while (running) {
            while(stopped == true){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //pick a new cell to explore
            Random r1 = new Random();
            int row = r1.nextInt(5);
            Random r2 = new Random();
            int column = r2.nextInt(5);
            if(explore.getMap().visit(row, column, this) == false)
                running = false;
            if(explore.getMap().hasExtracted() == true) {
                nrOfTokens += 5;
            }
            //make the robot sleep for some time
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " extracted " + this.getNrOfTokens() + " tokens.");
    }

    public int getNrOfTokens() {
        return nrOfTokens;
    }

    public Exploration getExplore() {
        return explore;
    }

    public void stopRobot() {
        if(stopped == true) System.out.println(name + " is already stopped");
        else {
            stopped = true;
            System.out.println(name + " stopped.");
        }
    }

    public String getName() {
        return name;
    }
    public void startRobot() {
        if(stopped = false) System.out.println(name + " is already running");
        else {
            stopped = false;
            System.out.println(name + " started.");
        }
    }

    @Override
    public String toString() {
        return "Robots = " +
                "name='" + name + '\'';
    }

    public void interruptRobot() {
        //interrupted = true;
        running = false;
    }
}
