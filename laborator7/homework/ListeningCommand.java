package org.example;

import java.util.Scanner;
/*
COMENZI POSIBILE:
    start all, stop all, start robot, stop robot
 */
public class ListeningCommand extends Thread {
    Exploration explore;
    ListeningCommand(Exploration explore){
        this.explore = explore;
    }
    @Override
    public void run() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String command  = scanner.nextLine();
            String[] tokens = command.split(" ");

            if(tokens.length == 2){
                if ((tokens[0].equals("stop") || tokens[0].equals("start")) && tokens[1].equals("robot")) {
                    System.out.println("Enter the name of the robot you want to stop.");
                    System.out.println("(-- " + explore.getRobots() + " --)");
                    System.out.println();
                    String robotName  = scanner.nextLine();
                    boolean nameFound = false;
                    for (Robot robot : explore.getRobots()){
                        if(robot.getName().equals(robotName)){
                            nameFound = true;
                            if(tokens[0].equals("stop"))
                                robot.stopRobot();
                            else robot.startRobot();
                            break;
                        }
                    }
                    if (!nameFound) {
                        System.out.println("Unknown robot: " + robotName);
                    }
                }else if (tokens[0].equals("stop") && tokens[1].equals("all")) {
                    for (Robot robot : explore.getRobots()) {
                        robot.stopRobot();
                    }
                }else if (tokens[0].equals("start") && tokens[1].equals("all")) {
                    for (Robot robot : explore.getRobots()) {
                        robot.startRobot();
                    }
                }
            } else {
                System.out.println("Unknown command: " + command);
            }

        }
    }
}
