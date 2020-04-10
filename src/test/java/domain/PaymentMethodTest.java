package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentMethodTest {

    @DisplayName("payment method test")
    @ParameterizedTest
    @CsvSource(value = {"1,CREDIT_CARD", "2,CASH"})
    void ofTest(int number, PaymentMethod paymentMethod) {
        assertThat(PaymentMethod.of(number)).isEqualTo(paymentMethod);
    }
}
