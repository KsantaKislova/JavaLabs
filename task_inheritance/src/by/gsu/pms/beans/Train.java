package by.gsu.pms.beans;

import java.util.Arrays;
import java.util.Comparator;

public class Train {
    private int maxNumberOfCarriages;
    private RailwayCarriage[] carriages;
    private int currentNumber;

    public int getTotalNumber(){
        int total = 0;
        for (int i = 0; i < currentNumber; i++) {
            total += carriages[i].getNumberOfBaggage();
            total += carriages[i].getNumberOfPassenger();
        }
        return total;
    }

    public void sortByComfort(){
        Arrays.sort(carriages);
    }

    public RailwayCarriage[] getCarriagesInRad(int minPas, int maxPas){
        int size = 0;
        RailwayCarriage[] rc = new RailwayCarriage[currentNumber];
        int cur;
        for (int i = 0; i < currentNumber; i++) {
            cur = carriages[i].getNumberOfPassenger();
            if(cur < maxPas & cur > minPas) {
                rc[size] = carriages[i];
                size++;
            }
        }
        return Arrays.copyOf(rc,size);
    }

    public Train(int numberOfCarriages) {
        this.currentNumber = 0;
        this.maxNumberOfCarriages = numberOfCarriages;
        this.carriages = new RailwayCarriage[numberOfCarriages];
    }

    public void addCarriage(RailwayCarriage railwayCarriage){
        if (currentNumber < maxNumberOfCarriages)
            carriages[currentNumber] = railwayCarriage;
        currentNumber++;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public int getMaxNumberOfCarriages() {
        return maxNumberOfCarriages;
    }

    public void setMaxNumberOfCarriages(int maxNumberOfCarriages) {
        this.maxNumberOfCarriages = maxNumberOfCarriages;
    }

    public RailwayCarriage[] getCarriages() {
        return carriages;
    }

    public void setCarriages(RailwayCarriage[] carriages) {
        this.carriages = carriages;
        this.currentNumber = carriages.length;
    }
}
