package by.gsu.pms;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{

    private Product product;
    private int numberOfUnits;

    public AbstractPurchase(){

    }

    public AbstractPurchase(Product product, int numberOfUnits) {
        this.product = product;
        this.numberOfUnits = numberOfUnits;
    }

    public Byn getCost(){
        return product.getPrice().mul(numberOfUnits);
    }

    protected Byn getUnroundedCost() {
        return product.getPrice().mul(numberOfUnits);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    protected String fieldsToString() {
        return product + ";" + numberOfUnits;
    }

    public String toString() {
        return  fieldsToString() + ";" + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return -this.getCost().compareTo(o.getCost());
    }
}