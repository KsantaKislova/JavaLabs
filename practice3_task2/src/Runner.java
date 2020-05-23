import by.gsu.pms.*;

import java.util.Arrays;

public class Runner {

    private static void printPurchases(AbstractPurchase[] purchases){
        for (AbstractPurchase purchase: purchases){
            System.out.println(purchase);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        //creating purchases
        Product product = new Product("Milk", new Byn(100));
        AbstractPurchase[] purchases = {
                new PriceDiscountPurchase(product, 11, new Byn(17)),
                new PriceDiscountPurchase(product, 5, new Byn(8)),
                new PercentDiscountPurchase(product, 11, 4),
                new PercentDiscountPurchase(product, 6, 3.45),
                new AdditionExpensesPurchase(product, 100, new Byn(3000)),
                new AdditionExpensesPurchase(product, 152, new Byn(4000))
        };

        //printing and sorting
        printPurchases(purchases);
        Arrays.sort(purchases);
        printPurchases(purchases);
        System.out.println("Min cost is " + purchases[purchases.length - 1].getCost());

        //searching
        int index = Arrays.binarySearch(purchases, new AbstractPurchase() {
            @Override
            public Byn getCost() {
                return new Byn(500);
            }
        });
        if (index >= 0){
            System.out.println(purchases[index]);
        } else {
            System.out.println("No such purchase");
        }
    }
}