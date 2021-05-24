package by.gsu.pms.beans;

import by.gsu.pms.enums.ComfortLevel;
import by.gsu.pms.enums.MealType;

public class SleepingCar extends RailwayCarriage {
    private static final ComfortLevel comfortLevel = ComfortLevel.VERY_HIGH;
    private int numberOfBeds;
    private MealType breakfast;
    private MealType lunch;
    private MealType dinner;

    public SleepingCar(int numberOfBeds) {
        super();
        setNumberOfBeds(0);
    }

    public SleepingCar(int baggageNumber, int passengerNumber, int numberOfBeds) {
        super(baggageNumber, passengerNumber);
        setNumberOfBeds(numberOfBeds);
    }

    public SleepingCar(int baggageNumber, int passengerNumber, int numberOfBeds
            , MealType breakfast
            , MealType lunch
            , MealType dinner) {
        this(baggageNumber,passengerNumber,numberOfBeds);
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public MealType getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(MealType breakfast) {
        this.breakfast = breakfast;
    }

    public MealType getLunch() {
        return lunch;
    }

    public void setLunch(MealType lunch) {
        this.lunch = lunch;
    }

    public MealType getDinner() {
        return dinner;
    }

    public void setDinner(MealType dinner) {
        this.dinner = dinner;
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
        return "SleepingCar   : " +
                super.toString() +
                "numberOfBeds=" + numberOfBeds +
                "; breakfast=" + breakfast +
                "; lunch=" + lunch +
                "; dinner=" + dinner + "\n";
    }
}
