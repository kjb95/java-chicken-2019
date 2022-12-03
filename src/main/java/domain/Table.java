package domain;

import constant.Const;
import constant.ErrorMessage;
import java.util.HashMap;
import java.util.Map;

public class Table {

    private final int number;
    private final Map<Menu, Integer> menuAndQuantity = new HashMap<>();

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
}
