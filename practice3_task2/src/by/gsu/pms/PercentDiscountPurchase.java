package by.gsu.pms;

public class PercentDiscountPurchase extends AbstractPurchase {

    private double discountPercentage;
    private static final int UNITS_UNTIL_DISCOUNT = 5;

    public PercentDiscountPurchase() {
    }

    public PercentDiscountPurchase(Product product, int numberOfUnits, double discountPercentage) {
        super(product, numberOfUnits);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public Byn getCost() {
        Byn cost = getUnroundedCost();
        if (getNumberOfUnits() > UNITS_UNTIL_DISCOUNT) {
            cost = cost.mul((int) (1 - discountPercentage / 100));
        }
        return cost;
    }

    @Override
    protected String fieldsToString() {
        return  super.fieldsToString() + ";" + discountPercentage;
    }

}
