package domain;

import java.util.Arrays;

public enum Command {
    ORDER(1),
    PAY(2),
    END(3);

    private final int number;

    Command(final int number) {
        this.number = number;
    }

    public static Command of(int number) {
        return Arrays.stream(values())
                .filter(aCommand -> aCommand.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("number : %d, Command의 number는 1부터 3까지 입니다.", number)));
    }
}
