package by.gsu.pms;
import by.gsu.pms.beans.Byn;
import by.gsu.pms.beans.PricePurchase;
import by.gsu.pms.beans.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Runner {

    public static void main(String[] args) {
        final int PURCHASE_LENGTH = Purchase.class.getDeclaredFields().length;
        final int PRICE_PURCHASE_LENGTH = PURCHASE_LENGTH + Purchase.class.getDeclaredFields().length;
        final Byn FIND_THIS_COST = new Byn(10000);

        // 1. Load the content of input file into collection
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("src/in.csv"));
            ArrayList<Purchase> result = new ArrayList<>();

            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split(";");
                if (line.length == PURCHASE_LENGTH) {
                    result.add( new Purchase (line[0], new Byn(Integer.parseInt(line[1])), Integer.parseInt(line[2])) );
                } else if (line.length == PRICE_PURCHASE_LENGTH) {
                    result.add( new PricePurchase(line[0], new Byn(Integer.parseInt(line[1])), Integer.parseInt(line[2]), new Byn(Integer.parseInt(line[3]))) );
                }
            }


            // 2. Print collection by separate for–each cycle.
            for (Purchase purchase : result) {
                System.out.println(purchase);
            }


            // 3. Print the purchase with the index 2.
            System.out.println("The 2th index purchase data: ");
            System.out.println(result.get(2));


            // 4. Delete purchases with the price less than 10000 (use iterator).
            Iterator<Purchase> iterator = result.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getPrice().compareTo(FIND_THIS_COST) < 0) {
                    iterator.remove();
                }
            }


            // 5. Find and print any purchase with the cost equaled 35000
            Purchase findPurchase = new Purchase("coconut", new Byn(35000), 5);
            int indexRequiredPurchase = Collections.binarySearch(result, findPurchase);

            System.out.println(" ");
            for (Purchase purchase : result) {
                System.out.println(purchase);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
