package com.labdoi.compulsory;
/**
 * Clasa City
 *
 * @author Moisa Iulia-Elena
 */
public class City extends Location{
    public double population;

    /**
     * constructor
     * @param population the number of people living in a certain city
     */
    public City(long population){
        this.population = population;
    }

    /**
     *  overriding toString method
     * @return String representation of an object
     */
    @Override
    public String toString() {
        return super.toString() + ", population=" + population + '}';
    }
}
