package com.labdoi.compulsory;
/**
 * Clasa GasStation
 *
 * @author Moisa Iulia-Elena
 */
public class GasStation extends Location{
    public float gasPrice;

    /**
     * GasStation constructor
     * @param gasPrice gas price at a certain gas station
     */
    public GasStation(float gasPrice){
        this.gasPrice = gasPrice;
    }

    /**
     * overriding toString method
     * @return String representation of an object
     */
    @Override
    public String toString() {
        return super.toString() + ", gasPrice=" + gasPrice + '}';
    }
}
