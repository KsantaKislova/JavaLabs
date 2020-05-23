package by.gsu.pms;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase{
    private final int necessaryUnitsNumber = 10;
    private double discount;
    public PercentDiscountPurchase(Scanner scanner) {
        super(scanner);
        this.discount = scanner.nextDouble();
    }

    public PercentDiscountPurchase(String name, int price, int numberOfUnits, double discount) {
        super(name, price, numberOfUnits);
        this.discount = discount;
    }

    public PercentDiscountPurchase() {
        super();
        discount = 0.0;
    }

    @Override
    public Byn getCost() {
        Byn cost = super.getCost();
        if(getNumberOfUnits() > necessaryUnitsNumber)
            cost.mul(1.0 - discount/100);
        return cost;
    }

    @Override
    public String fieldsToString(){
        return  String.format("%s%.2f%%;",
                super.fieldsToString(),
                discount);
    }
}
