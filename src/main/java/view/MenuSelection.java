package view;

import constant.ErrorMessage;
import java.util.Arrays;

public enum MenuSelection {
    ONE("1", 16000),
    TWO("2", 16000),
    THREE("3", 16000),
    FOUR("4", 16000),
    FIVE("5", 17000),
    SIX("6", 17000),
    TWENTY_ONE("21", 1000),
    TWENTY_TWO("22", 1000);

    private final String selection;
    private final int price;

    MenuSelection(String selection, int price) {
        this.selection = selection;
        this.price = price;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(MenuSelection.values())
                .anyMatch(menuSelection -> menuSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

    public int getPrice() {
        return price;
    }
}
