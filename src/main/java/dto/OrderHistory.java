package dto;

public class OrderHistory {

    private final String menu;
    private final int quantity;
    private final int price;

    public OrderHistory(String menu, int quantity, int price) {
        this.menu = menu;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return menu + " " + quantity + " " + price;
    }
}