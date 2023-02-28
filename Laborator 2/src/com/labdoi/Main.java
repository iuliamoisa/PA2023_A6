package com.labdoi;
import com.labdoi.compulsory.Location;
import com.labdoi.compulsory.Road;

public class Main {
    public static void main(String[] args) {
        Location loc1 = new Location(Location.TypeOfLocation.CITY);
        loc1.setName("Bucharest");
        loc1.setCoordinates(44.44924957245035, 26.0966896882998);
        System.out.println("The name of the location is: " + loc1.getName());
        System.out.println("The location represents a(n): " + loc1.getTypeOfLocation());
        System.out.println("The coordinates of the location are: " + loc1.xCoordinates() + "," + loc1.yCoordinates());
        System.out.println(loc1.toString());

        Location loc2 = new Location(Location.TypeOfLocation.AIRPORT);
        loc2.setName("Henri Coanda");
        loc2.setCoordinates(44.57088344006308, 26.084390839651025);
        System.out.println(loc2.toString());

        Location loc3 = new Location(Location.TypeOfLocation.GAS_STATION);
        loc3.setName("OMV");
        loc3.setCoordinates(44.59736968588774, 26.069989946423842);
        System.out.println(loc3.toString());

        Road r1 = new Road(Road.TypeOfRoad.HIGHWAY);
        r1.setTypeOfRoad(Road.TypeOfRoad.HIGHWAY);
        System.out.println("The type of road r1 is: " + r1.getTypeOfRoad());
        //r1.returnType();
        r1.setLength(500);
        System.out.println("The length of road r1 is: " + r1.getLength());
        r1.setSpeedLimit(70);
        System.out.println("The speed limit of the road r1 is: " + r1.getSpeedLimit());
        System.out.println(r1.toString());
    }
}