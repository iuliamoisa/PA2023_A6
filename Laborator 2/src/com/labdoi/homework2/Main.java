package com.labdoi;
import com.labdoi.compulsory.*;
import com.labdoi.homework.Problem;
/**
 * Clasa Main
 *
 * @author Moisa Iulia-Elena
 */
public class Main {
    /**
     *metoda main
     * @param args argumentele date la linia de comanda
     */
    public static void main(String[] args) {
        Location loc1 = new City(1700000);
        loc1.setName("Bucharest");
        loc1.setCoordinates(44.44924957245035, 26.0966896882998);
        System.out.println("The name of the location is: " + loc1.getName());
        System.out.println("The coordinates of the location are: " + loc1.xCoordinates() + "," + loc1.yCoordinates());

        Location loc2 = new Airport(4);
        loc2.setName("Henri Coanda");
        loc2.setCoordinates(44.57088344006308, 26.084390839651025);

        Location loc3 = new GasStation(9.5f);
        loc3.setName("OMV");
        loc3.setCoordinates(44.59736968588774, 26.069989946423842);

        Location loc4 = new City( 50713);
        loc4.setName("Roman");
        loc4.setCoordinates(46.93331490575542, 26.928368121024015);
        Location loc5 = new City( 144307);
        loc5.setName("Bacau");
        loc5.setCoordinates(46.566617612182114, 26.916409992934888);

        System.out.println(loc1);
        System.out.println(loc2);
        System.out.println(loc3);
        System.out.println(loc4);
        Location[] locations = new Location[5];
        locations[0] = loc1;
        locations[1] = loc2;
        locations[2] = loc3;
        locations[3] = loc4;
        locations[4] = loc5;

        Road r1 = new Road(Road.TypeOfRoad.HIGHWAY, loc1, loc2);//r1 leaga loc1 si loc2
        r1.setTypeOfRoad(Road.TypeOfRoad.HIGHWAY);
        r1.setLength(500);
        r1.setSpeedLimit(130);
        System.out.println("The type of road r1 is: " + r1.getTypeOfRoad());
        System.out.println("The length of road r1 is: " + r1.getLength());
        System.out.println("The speed limit of the road r1 is: " + r1.getSpeedLimit());

        Road r2 = new Road(Road.TypeOfRoad.EXPRESS, loc2, loc3);//r2 leaga loc2 si loc3
        r2.setTypeOfRoad(Road.TypeOfRoad.EXPRESS);
        r2.setLength(750);
        r2.setSpeedLimit(120);
        System.out.println("The type of road r2 is: " + r2.getTypeOfRoad());
        System.out.println("The length of road r2 is: " + r2.getLength());
        System.out.println("The speed limit of the road r2 is: " + r2.getSpeedLimit());

        Road r3 = new Road(Road.TypeOfRoad.COUNTRY, loc4, loc5);//r3 leaga loc4 si loc 5
        r3.setTypeOfRoad(Road.TypeOfRoad.COUNTRY);
        r3.setLength(100);
        r3.setSpeedLimit(80);

        //System.out.println(r1);
        //System.out.println(r2);
        Road[] roads = new Road[3];
        roads[0] = r1;
        roads[1] = r2;
        roads[2] = r3;


        Problem instanceOfProblem = new Problem();
        instanceOfProblem.addLocation(loc1);
        instanceOfProblem.addLocation(loc2);
        //instanceOfProblem.addLocation(loc2); //error: cannot add same location twice
        instanceOfProblem.addLocation(loc3);
        instanceOfProblem.addLocation(loc4);
        instanceOfProblem.addLocation(loc5);
        instanceOfProblem.addRoad(r1);
        //instanceOfProblem.addRoad(r1); //error
        instanceOfProblem.addRoad(r2);
        instanceOfProblem.addRoad(r3);
        instanceOfProblem.checkInstance();

        //drumuri posibile: Bucuresti-Henri Coanda, Henri Coanda-OMV,Roman-Bacau
        boolean checkLoc1Loc4 = instanceOfProblem.existsRoadBetweenFirstAndSecond(loc1, loc4);
        if (checkLoc1Loc4)
            System.out.println("It is possible to go from " + loc1.getName() +  " to " + loc4.getName());
        else
            System.out.println("It is not possible to go from " + loc1.getName() +  " to " + loc4.getName());
        System.out.println();
        boolean checkLoc4Loc5 = instanceOfProblem.existsRoadBetweenFirstAndSecond(loc4, loc5);
        if (checkLoc4Loc5)
            System.out.println("It is possible to go from " + loc4.getName() +  " to " + loc5.getName());
        else
            System.out.println("It is not possible to go from " + loc4.getName() +  " to " + loc5.getName());
        System.out.println();
        boolean checkLoc1Loc3 = instanceOfProblem.existsRoadBetweenFirstAndSecond(loc1, loc3);
        if (checkLoc4Loc5)
            System.out.println("It is possible to go from " + loc1.getName() +  " to " + loc3.getName());
        else
            System.out.println("It is not possible to go from " + loc1.getName() +  " to " + loc3.getName());

    }
}