package by.gsu.pms.beans;

import by.gsu.pms.enums.ComfortLevel;
import by.gsu.pms.enums.MealType;

public class CoupeCarriage extends RailwayCarriage {
    private static final ComfortLevel comfortLevel = ComfortLevel.HIGH;
    private int numberOfBeds;
    private MealType breakfast;

    public CoupeCarriage(int numberOfBeds) {
        super();
        setNumberOfBeds(0);
    }

    public CoupeCarriage(int baggageNumber, int passengerNumber, int numberOfBeds) {
        super(baggageNumber, passengerNumber);
        setNumberOfBeds(numberOfBeds);
    }

    public CoupeCarriage(int baggageNumber, int passengerNumber, int numberOfBeds, MealType breakfast) {
        this(baggageNumber,passengerNumber,numberOfBeds);
        this.breakfast = breakfast;
    }

    public MealType getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(MealType breakfast) {
        this.breakfast = breakfast;
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
        return "CoupeCarriage : " +
                super.toString() +
                "numberOfBeds=" + numberOfBeds +
                "; breakfast=" + breakfast + "\n";
    }
}