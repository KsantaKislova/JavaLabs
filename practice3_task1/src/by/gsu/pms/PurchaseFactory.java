package by.gsu.pms;

import java.util.Scanner;

public class PurchaseFactory {

    public static Purchase getPurchaseFromFactory(Scanner scanner) {
        String id = scanner.next();
        PurchaseKind purchaseKind = PurchaseKind.valueOf(id);
        return purchaseKind.readPurchase(scanner);
    }

    private static enum PurchaseKind {
        GENERAL_PURCHASE {
            @Override
            public Purchase readPurchase(Scanner scanner) {
                return new Purchase(scanner);
            }
        },
        PRICE_DISCOUNT_PURCHASE {
            @Override
            public PriceDiscountPurchase readPurchase(Scanner scanner) {
                return new PriceDiscountPurchase(scanner);
            }
        },
        PERCENT_DISCOUNT_PURCHASE {
            @Override
            public PercentDiscountPurchase readPurchase(Scanner scanner) {
                return new PercentDiscountPurchase(scanner);
            }
        };

        abstract Purchase readPurchase(Scanner scanner);
    }

}
