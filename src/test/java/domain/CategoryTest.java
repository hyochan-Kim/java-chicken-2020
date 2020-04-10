package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryTest {
    @DisplayName("category toString test")
    @ParameterizedTest
    @CsvSource(value = {"CHICKEN,[치킨]", "BEVERAGE,[음료]"})
    void toStringTest(Category category, String answer) {
        assertThat(category.toString()).isEqualTo(answer);
    }
}