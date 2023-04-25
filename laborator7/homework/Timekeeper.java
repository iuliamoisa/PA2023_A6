package org.example;
/**
 * Daemon class used for time keeping of a game.
 */

public class Timekeeper implements Runnable {

    private long timeLimit;
    private long runningTime;
    Exploration explore;

    public Timekeeper(long timeLimit, Exploration explore) {
        this.timeLimit = timeLimit;
        this.explore = explore;
    }

    @Override
    public void run() {
        long startingTime = System.currentTimeMillis();
        long timeDiff = startingTime;
        runningTime = System.currentTimeMillis();
        while ((runningTime - startingTime) <= timeLimit) {
            runningTime = System.currentTimeMillis();
            if (runningTime - timeDiff >= 60000) {
                timeDiff = runningTime;
                System.out.println(" -- > One minute has passed... ");
            }
        }
        for (Robot robot : explore.getRobots()){
            robot.interruptRobot();
        }
        System.out.println(" -- >Time limit exceeded... ");
    }

    public long getRunningTime() {
        return runningTime;
    }
}
