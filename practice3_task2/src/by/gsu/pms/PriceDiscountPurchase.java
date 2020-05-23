package by.gsu.pms;

public class PriceDiscountPurchase extends AbstractPurchase {

    private Byn discount;

    public PriceDiscountPurchase() {
    }

    public PriceDiscountPurchase(Product product, int numberOfUnits, Byn discount) {
        super(product, numberOfUnits);
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return getUnroundedCost().sub(new Byn(discount).mul(getNumberOfUnits()));
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

    public String toString() {
        return  fieldsToString() + ";" + getCost();
    }

}