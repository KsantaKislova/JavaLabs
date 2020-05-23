package by.gsu.pms;

public class Product {

    private final String name;
    private final Byn price;

    public Product(String name, Byn price) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ";" + price;
    }
}