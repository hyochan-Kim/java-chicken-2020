package domain;

import java.util.Map;
import java.util.Objects;

public class Table {
    private final int number;
    private final OrderHistory orderHistory;

    public Table(final int number) {
        this.number = number;
        orderHistory = new OrderHistory();
    }

    public void addOrder(Menu menu, int count) {
        orderHistory.add(menu, count);
    }

    public void pay() {
        orderHistory.reset();
    }

    public boolean hasUnpaidOrder() {
        return orderHistory.hasOrder();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }

    public Map<Menu, Integer> getOrderHistory() {
        return orderHistory.getOrderHistory();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Table table = (Table) o;
        return number == table.number &&
                Objects.equals(orderHistory, table.orderHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, orderHistory);
    }
}
