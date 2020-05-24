package by.gsu.pms.beans;

import java.util.Scanner;
import java.util.Objects;

public class Purchase implements Comparable<Purchase>{
    private String productName;
    private Byn price;
    private int numberOfUnits;

    public Purchase() {
    }

    public Purchase(Scanner scanner) {
        this.productName = scanner.next();
        this.price = new Byn(scanner.nextInt());
        this.numberOfUnits = scanner.nextInt();
    }

    public Purchase(String name, Byn price, int numberOfUnits) {
        this.productName = name;
        this.price = price;
        this.numberOfUnits = numberOfUnits;
    }

    /*public Purchase(String name, int price, int numberOfUnits){
        this.productName = name;
        this.price = new Byn(price);
        this.numberOfUnits = numberOfUnits;
    }
     */


    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = new Byn(price);
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public Byn getCost(){
        return new Byn(price).mul(numberOfUnits);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Purchase)) return false;

        Purchase purchase = (Purchase) o;
        return Objects.equals(productName, purchase.productName) &&  price.equals(purchase.price);
    }

    @Override
    public String toString() {
        return  fieldsToString() + getCost();
    }

    protected String fieldsToString() {
        return  productName + ";" + price + ";" + numberOfUnits + ";";
    }

    @Override
    public int compareTo(Purchase purchase) {
        return getCost().compareTo(purchase.getCost());
    }
}