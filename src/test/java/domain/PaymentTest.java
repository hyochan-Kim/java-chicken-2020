package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTest {
    @DisplayName("최종 결제 금액 산정 테스트")
    @Test
    void calculateTotalPrice() {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.add(MenuRepository.menus().get(0), 3); // 16000 * 3 = 48000
        orderHistory.add(MenuRepository.menus().get(1), 5); // 16000 * 5 = 80000
        Price totalPrice = Payment.calculateTotalPrice(orderHistory.getOrderHistory());
        assertThat(totalPrice).isEqualTo(new Price(128000));
    }

    @DisplayName("현금 할인 테스트")
    @Test
    void discountCash() {
        Price price = new Price(10000);
        assertThat(Payment.discountCash(price)).isEqualTo(new Price(9500));
    }
}
