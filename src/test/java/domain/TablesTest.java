package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TablesTest {
    @DisplayName("주문 넣기 테스트")
    @Test
    void addOrderToTable() {
        Tables tables = new Tables(TableRepository.tables());
        tables.addOrderToTable(1, MenuRepository.menus().get(0), 1);
        assertThat(tables.hasUnpaidOrder(1)).isTrue();
    }

    @DisplayName("결제 테스트")
    @Test
    void pay() {
        Tables tables = new Tables(TableRepository.tables());
        tables.addOrderToTable(1, MenuRepository.menus().get(0), 1);
        tables.pay(1);
        assertThat(tables.hasUnpaidOrder(1)).isFalse();
    }
}
