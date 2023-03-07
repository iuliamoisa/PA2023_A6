package com.labdoi.compulsory;
import java.util.Objects;
/**
 * Clasa Road
 *
 * @author Moisa Iulia-Elena
 */
public class Road {
    /**
     * Each road has a type, length and a speed limit.
     * The length of a road should not be less than the euclidian distance between the location coordinates.
     * Roads may be highways, express, country, etc. Possible types of roads are expressed as enums
     */
    public enum TypeOfRoad {
        HIGHWAY,
        EXPRESS,
        COUNTRY
    }

    private TypeOfRoad type;
    /**
     * a road connects two locations
     */
    Location firstLocation, secondLocation;

    /**
     * constructor
     * @param type type of the road
     * @param loc1 the source location
     * @param loc2 the destination
     */

    public Road(TypeOfRoad type, Location loc1, Location loc2) {

        this.type = type;
        this.firstLocation = loc1;
        this.secondLocation = loc2;
    }

    /**
     * getters for the locations
     * @return the locations which are connected by the road
     */
    public Location getFirstLocation() {
        return firstLocation;
    }

    public Location getSecondLocation() {
        return secondLocation;
    }

    /**
     *
     * @param type type of the road
     */
    public void setTypeOfRoad(TypeOfRoad type) {

        this.type = type;
    }

    /**
     * getter for the type of the road
     * @return type of road
     */
    public TypeOfRoad getTypeOfRoad() {
        return type;
    }

    private float length;

    /**
     * getter and setter for the length of the road
     * @param length length of the road
     */
    public void setLength(float length) {

        this.length = length;
    }

    public float getLength() {
        return length;
    }

    private int speedLimit;

    /**
     * getter and setter for the spped limit
     * @param speedLimit spped limit of the road
     */

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    /**
     *
     * @return String representation of an object
     */

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
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
        if (!(o instanceof Road road)) return false;
        return Float.compare(road.getLength(), getLength()) == 0 && getSpeedLimit() == road.getSpeedLimit() && type == road.type;
    }
    /**
     * hashCode() must be overriden in every class that overrides equals().
     * Otherwise, it will result a violation of the general contract for Object.hashCode(),
     * which will prevent the class from functioning properly in conjunction with all hash-based collections
     * @return the integer hash code value of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, getLength(), getSpeedLimit());
    }
}
