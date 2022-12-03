package domain;

import constant.Const;
import constant.ErrorMessage;
import dto.OrderHistory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Table {

    private final int number;
    private Map<Menu, Integer> menuAndQuantity = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public void order(int menuNumber, int orderQuantity) {
        Menu menu = MenuRepository.findMenuByNumber(menuNumber);
        int remainingQuantity = menuAndQuantity.getOrDefault(menu, Const.EMPTY_MENU_QUANTITY);
        int currentQuantity = remainingQuantity + orderQuantity;
        if (currentQuantity > Const.MENU_QUANTITY_MAX) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_MENU_QUANTITY);
        }
        menuAndQuantity.put(menu, currentQuantity);
    }

    public List<OrderHistory> createOrderHistory() {
        return menuAndQuantity.keySet()
                .stream()
                .filter(menu -> menuAndQuantity.get(menu) != Const.EMPTY_MENU_QUANTITY)
                .map(this::createOrderHistory)
                .collect(Collectors.toList());
    }

    private OrderHistory createOrderHistory(Menu menu) {
        String menuName = menu.getName();
        int quantity = menuAndQuantity.get(menu);
        int price = menu.getPrice();
        return new OrderHistory(menuName, quantity, price);
    }

    public int computeFinalPrice(int payMethod) {
        int bundlesCount = countBundles();
        int priceBeforeDiscount = sumPrice();
        double finalPrice = priceBeforeDiscount - bundlesCount * Const.BUNDLE_DISCOUNT;
        if (payMethod == Const.CASH_PAY_METHOD) {
            finalPrice *= Const.CASH_DISCOUNT;
        }
        return (int) finalPrice;
    }

    private int countBundles() {
        return menuAndQuantity.keySet()
                .stream()
                .map(menu -> menuAndQuantity.get(menu))
                .mapToInt(quantity -> quantity / Const.BUNDLE_SIZE)
                .sum();
    }

    private int sumPrice() {
        return menuAndQuantity.keySet()
                .stream()
                .map(this::computeOneMenuPrice)
                .mapToInt(price -> price)
                .sum();
    }

    private int computeOneMenuPrice(Menu menu) {
        int price = menu.getPrice();
        int quantity = menuAndQuantity.get(menu);
        return price * quantity;
    }

    public void clear() {
        menuAndQuantity = new HashMap<>();
    }
}
