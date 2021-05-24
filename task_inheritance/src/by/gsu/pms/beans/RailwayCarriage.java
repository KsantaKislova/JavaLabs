package by.gsu.pms.beans;

import by.gsu.pms.enums.ComfortLevel;

public abstract class RailwayCarriage implements Comparable<RailwayCarriage>{
    private int numberOfBaggage;
    private int numberOfPassenger;

    public RailwayCarriage() {
        this.numberOfBaggage = 0;
        this.numberOfPassenger = 0;
    }

    public RailwayCarriage(int baggageNumber, int passengerNumber) {
        setNumberOfBaggage(baggageNumber);
        setNumberOfPassenger(passengerNumber);
    }

    public int getNumberOfBaggage() {
        return numberOfBaggage;
    }

    public void setNumberOfBaggage(int numberOfBaggage) {
        if(numberOfBaggage <0)
            throw new RuntimeException("Number can\'t be less than zero!");
        this.numberOfBaggage = numberOfBaggage;
    }

    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }

    public void setNumberOfPassenger(int numberOfPassenger) {
        if(numberOfPassenger <0)
            throw new RuntimeException("Number can\'t be less than zero!");
        this.numberOfPassenger = numberOfPassenger;
    }

    public abstract ComfortLevel getComfortLevel();

    @Override
    public int compareTo(RailwayCarriage o) {
        return getComfortLevel().compareTo(o.getComfortLevel());
    }

    @Override
    public String toString() {
        return  "numberOfBaggage=" + numberOfBaggage +
                "; numberOfPassenger=" + numberOfPassenger;
    }
}
