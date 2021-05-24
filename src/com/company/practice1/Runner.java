package com.company.practice1;
import by.gsu.pms.BusinessTrip;

public class Runner {
    public static void main(String[] args) {
        // Create elements array of type BusinessTrip
        BusinessTrip[] tripsArray = new BusinessTrip[7];

        // Initialize array
        tripsArray[0] = new BusinessTrip("Tom", 25000, 2);
        tripsArray[1] = new BusinessTrip("Helen", 30000000, 1);
        tripsArray[3] = new BusinessTrip("Leo", 45000, 8);
        tripsArray[4] = new BusinessTrip("Vlad", 1000000, 10);
        tripsArray[5] = new BusinessTrip("Serega", 60000, 11);
        tripsArray[6] = new BusinessTrip();

        // Print content using show()
        for (int i = 0; i < tripsArray.length; i++) {
            if (i != 2) {
                tripsArray[i].show();
            }
        }

        // Change the employee`s transportation expenses for the last object of the array
        tripsArray[tripsArray.length - 1].setTransportExpenses(35000);

        // Print the duration of two initial business trips by the single operator.
        System.out.printf("Duration = %d \n\n", tripsArray[0].getDays() + tripsArray[1].getDays());

        // Print the array content to the console (one element per line), using toString( ) method implicitly.
        for (int i = 0; i < tripsArray.length; i++) {
            if (i != 2) {
                System.out.println(tripsArray[i].toString());
            }
        }

        // Find the sum of total expenses
        System.out.printf("\nTotal expenses: %.2f\n", tripsArray[0].getTotal() + tripsArray[1].getTotal() +
                tripsArray[3].getTotal() + tripsArray[4].getTotal() +
                tripsArray[5].getTotal() + tripsArray[6].getTotal());

        // Find and print account name employee’s with maximum total expenses
        int maxElementIndex = 0;
        for (int j = 1; j < tripsArray.length; j++) {
            if (j != 2 && tripsArray[maxElementIndex].getTotal() < tripsArray[j].getTotal()) {
                maxElementIndex = j;
            }
        }
        System.out.printf("\nAccount name employee's with maximum total expenses: %s\n", tripsArray[maxElementIndex].getAccount());
    }
}
