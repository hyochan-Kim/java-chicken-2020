package domain;

import java.util.HashMap;
import java.util.Map;

public class OrderHistory {
    private final Map<Menu, Integer> orderHistory;

    public OrderHistory() {
        this(new HashMap<>());
    }

    public OrderHistory(final Map<Menu, Integer> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public void add(Menu menu, int amount) {
        if (orderHistory.containsKey(menu)) {
            orderHistory.put(menu, orderHistory.get(menu) + amount);
            return;
        }
        orderHistory.put(menu, amount);
    }

    public void reset() {
        orderHistory.clear();
    }

    public boolean hasOrder() {
        return !orderHistory.isEmpty();
    }

    public Map<Menu, Integer> getOrderHistory() {
        return orderHistory;
    }
}
