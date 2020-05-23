package by.gsu.pms;

public class AdditionExpensesPurchase extends AbstractPurchase {

    private Byn transportExpenses;

    public AdditionExpensesPurchase() {
    }

    public AdditionExpensesPurchase(Product product, int numberOfUnits, Byn transportExpenses) {
        super(product, numberOfUnits);
        this.transportExpenses = transportExpenses;
    }

    @Override
    public Byn getCost() {
        return (getUnroundedCost().sub(transportExpenses));
    }

    @Override
    protected String fieldsToString() {
        return  super.fieldsToString() + ";" + transportExpenses;
    }

}
