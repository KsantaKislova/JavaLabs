package by.gsu.pms;

import by.gsu.pms.Byn;
import by.gsu.pms.Purchase;
import by.gsu.pms.PurchaseFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        final int PURCHASE_NUMBER = 6;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/in.txt"));
            scanner.useLocale(Locale.ENGLISH);

            Purchase[] purchases = new Purchase[PURCHASE_NUMBER];

            Byn maxCost = new Byn(0);
            int maxCostIndex = -1;
            Byn tempCost;
            boolean allAreEqual = true;

            for(int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchaseFactory.getPurchaseFromFactory(scanner);
                System.out.println(purchases[i]);
                tempCost = purchases[i].getCost();
                if(tempCost.compareTo(maxCost) > 0){
                    maxCost = tempCost;
                    maxCostIndex = i;
                }
                if(allAreEqual)
                    allAreEqual = purchases[i].equals(purchases[0]);
            }
            if(allAreEqual)
                System.out.println("All purchases are equal!");
            else
                System.out.println("There are different purchases!");

            System.out.println("The purchase with the maximum cost is : " + purchases[maxCostIndex]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(scanner != null)
                scanner.close();
        }

    }
}
