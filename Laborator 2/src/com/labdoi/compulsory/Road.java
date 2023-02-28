package com.labdoi.compulsory;
//Two locations may be connected by a road, or not.
//The length of a road should not be less than the euclidian distance between the location coordinates.
public class Road {
    public enum TypeOfRoad {
        HIGHWAY,
        EXPRESS,
        COUNTRY
    }
        private TypeOfRoad type;
        public Road(TypeOfRoad type){
            this.type = type;
        }

        public void setTypeOfRoad(TypeOfRoad type){
            this.type = type;
        }
        public TypeOfRoad getTypeOfRoad(){
            return type;
        }

        private float length;
        public void setLength(float length) {
            this.length = length;
        }
        public float getLength(){
            return length;
        }

        private int speedLimit;
        public void setSpeedLimit(int speedLimit) {
            this.speedLimit = speedLimit;
        }
        public int getSpeedLimit() {
            return speedLimit;
        }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }

}
