package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {
    @DisplayName("더하기 테스트")
    @Test
    void sum() {
        Price price = new Price(500);
        Price price2 = new Price(1000);
        assertThat(price.sum(price2)).isEqualTo(new Price(1500));
    }

    @DisplayName("곱하기 테스트")
    @Test
    void multiply() {
        Price price = new Price(500);
        assertThat(price.multiply(5)).isEqualTo(new Price(2500));
    }
}
