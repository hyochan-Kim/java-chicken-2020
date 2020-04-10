package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenusTest {
    @DisplayName("주문 넣기 테스트")
    @Test
    void ofTest() {
        Menus menus = new Menus(MenuRepository.menus());
        assertThat(menus.of(1)).isEqualTo(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
    }
}
