package domain;

import java.util.Map;

public class Payment {

    private static final int DISCOUNT_PRICE = -10000;
    private static final int DISCOUNT_UNIT = 10;
    private static final int INITIAL_COUNT = 0;
    private static final Price ZERO_PRICE = new Price(0);
    private static final float CASH_DISCOUNT_RATIO = 0.95f;

    public static Price calculateTotalPrice(Map<Menu, Integer> orderHistory) {
        Price totalPrice = ZERO_PRICE;
        int totalCount = INITIAL_COUNT;
        for (Map.Entry<Menu, Integer> entry : orderHistory.entrySet()) {
            Price price = entry.getKey().getPrice();
            int count = entry.getValue();
            totalPrice = totalPrice.sum(price.multiply(count));
            totalCount += count;
        }
        Price discountPrice = new Price(DISCOUNT_PRICE);
        int discountNumber = totalCount / DISCOUNT_UNIT;
        discountPrice = discountPrice.multiply(discountNumber);
        return totalPrice.sum(discountPrice);
    }

    public static Price discountCash(Price price) {
        return price.multiply(CASH_DISCOUNT_RATIO);
    }
}
