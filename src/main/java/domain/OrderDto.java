package domain;

public class OrderDto {
    private String menuName;
    private int count;
    private Price totalPrice;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(final String menuName) {
        this.menuName = menuName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final Price totalPrice) {
        this.totalPrice = totalPrice;
    }
}
