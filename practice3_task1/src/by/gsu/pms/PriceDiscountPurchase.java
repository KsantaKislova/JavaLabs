package by.gsu.pms;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase{
    private Byn discount;

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    public PriceDiscountPurchase(Scanner scanner) {
        super(scanner);
        this.discount = new Byn(scanner.nextInt());
    }

    public PriceDiscountPurchase(String name, int price, int numberOfUnits, int discount) {
        super(name, price, numberOfUnits);
        this.discount = new Byn(discount);
    }

    public PriceDiscountPurchase() {
        super();
        discount = new Byn(0);
    }

    @Override
    public Byn getCost(){
        return (new Byn(getPrice())).sub(discount).mul(getNumberOfUnits());
    }

    @Override
    public String fieldsToString(){
        return  super.fieldsToString() + discount + ";" ;
    }
}
