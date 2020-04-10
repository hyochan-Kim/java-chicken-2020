package domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tables {
    private Map<Integer, Table> tables = new HashMap<>();

    public Tables(final List<Table> tables) {
        for (Table table : tables) {
            this.tables.put(table.getNumber(), table);
        }
    }

    public void addOrderToTable(int tableNumber, Menu menu, int count) {
        tables.get(tableNumber).addOrder(menu, count);
    }

    public void pay(int tableNumber) {
        tables.get(tableNumber).pay();
    }

    public boolean hasUnpaidOrder(int tableNumber) {
        return tables.get(tableNumber).hasUnpaidOrder();
    }

    public Table of(int tableNumber) {
        return tables.get(tableNumber);
    }

    public Collection<Table> values() {
        return tables.values();
    }

    public int size() {
        return tables.size();
    }
}
