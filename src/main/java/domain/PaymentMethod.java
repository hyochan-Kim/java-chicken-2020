package domain;

import java.util.Arrays;

public enum PaymentMethod {
    CREDIT_CARD(1),
    CASH(2);

    private final int number;

    PaymentMethod(final int number) {
        this.number = number;
    }

    public static PaymentMethod of(int number) {
        return Arrays.stream(values())
                .filter(paymentMethod -> paymentMethod.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("number : %d, 결제 수단은는 1(카드), 2(현금) 입니다.", number)));
    }
}
