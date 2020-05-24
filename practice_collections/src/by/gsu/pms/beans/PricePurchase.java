package by.gsu.pms.beans;

import java.util.Scanner;

public class PricePurchase extends Purchase{
    private Byn discount;

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    public PricePurchase(Scanner scanner) {
        super(scanner);
        this.discount = new Byn(scanner.nextInt());
    }

    public PricePurchase(String name, Byn byn, int numberOfUnits, Byn byn1) {
    }

    public PricePurchase(String name, Byn price, int numberOfUnits, int discount) {
        super(name, price, numberOfUnits);
        this.discount = new Byn(discount);
    }

    //public PricePurchase(String name, Byn byn, int numberOfUnits, Byn byn1) {
    //    super();
    //    discount = new Byn(0);
    //}

    @Override
    public Byn getCost(){
        return (new Byn(getPrice())).sub(discount).mul(getNumberOfUnits());
    }

    @Override
    public String fieldsToString(){
        return  super.fieldsToString() + discount + ";" ;
    }

}
