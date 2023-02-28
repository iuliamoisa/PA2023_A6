package com.labdoi.compulsory;
//        AUREL_VLAICU("airport"),
//        LUKOIL("gas station"),
//        SOCAR("gas station"),
//        OMV("gas station");
//Two locations may be connected by a road, or not.
public class Location {
    public enum TypeOfLocation{
        CITY,
        AIRPORT,
        GAS_STATION
    }
    private Location.TypeOfLocation type;
    public Location(Location.TypeOfLocation type){
        this.type = type;
    }
    public void setTypeOfLocation(TypeOfLocation type) {
        this.type = type;
    }
    public Location.TypeOfLocation getTypeOfLocation(){
        return type;
    }
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    private double x, y;
     public void setCoordinates(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double xCoordinates(){ //get x coordinates
        return x;
    }
    public double yCoordinates(){ //get y coordinates
        return y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

}
