package by.gsu.pms.beans;

import by.gsu.pms.enums.ComfortLevel;

public class OpenCarriage extends RailwayCarriage {
    private static final ComfortLevel comfortLevel = ComfortLevel.MIDDLE;
    private int numberOfBeds;

    public OpenCarriage(int numberOfBeds) {
        super();
        setNumberOfBeds(0);
    }

    public OpenCarriage(int baggageNumber, int passengerNumber, int numberOfBeds) {
        super(baggageNumber, passengerNumber);
        setNumberOfBeds(numberOfBeds);
    }

   public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        if(numberOfBeds < 0)
            throw new RuntimeException("Number can\'t be less than zero!");
        this.numberOfBeds = numberOfBeds;
    }

    @Override
    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    @Override
    public String toString() {

        return "OpenCarriage  : " +
                super.toString() +
                "numberOfBeds=" + numberOfBeds + "\n";
    }
}