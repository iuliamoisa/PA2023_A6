package com.labdoi.compulsory;
/**
 * Clasa Airport
 *
 * @author Moisa Iulia-Elena
 */

public class Airport extends Location{
    public int numberOfTerminals;

    /**
     * constructor; an Airport object is created by specifying the number of terminals it has
     * @param numberOfTerminals how many terminals has a certain airport
     */
    public Airport(int numberOfTerminals){
        this.numberOfTerminals = numberOfTerminals;
    }

    /**
     * overriding toString method
     * @return String representation of an object
     */
    @Override
    public String toString() {
        return super.toString() + ", numberOfTerminals=" + numberOfTerminals + '}';
    }
}
