package domain;

import java.util.Objects;

public class Price {
    private final int price;

    public Price(final int price) {
        this.price = price;
    }

    public Price sum(Price price) {
        return new Price(this.price + price.price);
    }

    public Price multiply(float number) {
        return new Price((int) (this.price * number));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return Integer.toString(price);
    }
}
