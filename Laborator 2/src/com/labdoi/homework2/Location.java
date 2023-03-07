package com.labdoi.compulsory;
import java.util.Objects;
/**
 * Clasa Location
 *
 * @author Moisa Iulia-Elena
 */

public abstract class Location {
    /**
     * Each location has a name, type and x, y coordinates (assume that the locations are placed in a cartesian coordinate system).
     * Locations may be cities, airports, gas stations, etc.
     */

    protected String name; //daca era private, nu putea fi accesat de city
    /**
     * setter and getter for the name of a location
     */
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    private double x, y;

    /**
     *  setter for the coordinates of a location
     * @param x x coord
     * @param y y coord
     */
     public void setCoordinates(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * getters for the coordinates of a location
     * @return x and y coordinates
     */
    public double xCoordinates(){
        return x;
    }
    public double yCoordinates(){
        return y;
    }

    /**
     * overriding toString() method
     * @return a String representation of the object
     */
    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }


    /**
     * overriding equals in order to check if two objects are equal
     * two objects are equal if they have the same x,y coordinates and the same name
     * If two objects are equal according to equals() method, then their hash code must be same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Double.compare(location.x, x) == 0 && Double.compare(location.y, y) == 0 && getName().equals(location.getName());
    }

    /**
     * hashCode() must be overriden in every class that overrides equals().
     * Otherwise, it will result a violation of the general contract for Object.hashCode(),
     * which will prevent the class from functioning properly in conjunction with all hash-based collections
     * @return  the integer hash code value of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), x, y);
    }

}
