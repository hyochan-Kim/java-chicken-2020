package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderHistoryTest {
    @DisplayName("주문 추가 테스트")
    @Test
    void add() {
        OrderHistory orderHistory = new OrderHistory();
        Menu menu = MenuRepository.menus().get(0);
        orderHistory.add(menu, 1);
        assertThat(orderHistory.getOrderHistory().size()).isEqualTo(1);
    }

    @DisplayName("주문 초기화 테스트")
    @Test
    void reset() {
        OrderHistory orderHistory = new OrderHistory();
        Menu menu = MenuRepository.menus().get(0);
        orderHistory.add(menu, 1);
        orderHistory.reset();
        assertThat(orderHistory.hasOrder()).isFalse();
    }
}
