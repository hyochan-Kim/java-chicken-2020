package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @DisplayName("command test")
    @ParameterizedTest
    @CsvSource(value = {"1,ORDER", "2,PAY", "3,END"})
    void ofTest(int number, Command command) {
        assertThat(Command.of(number)).isEqualTo(command);
    }
}
