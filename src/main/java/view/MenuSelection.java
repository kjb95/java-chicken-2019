package view;

import constant.ErrorMessage;
import java.util.Arrays;

public enum MenuSelection {
    ONE("1", "후라이드", 16000),
    TWO("2", "양념치킨", 16000),
    THREE("3", "반반치킨", 16000),
    FOUR("4", "통구이", 16000),
    FIVE("5", "간장치킨", 17000),
    SIX("6", "순살치킨", 17000),
    TWENTY_ONE("21", "콜라", 1000),
    TWENTY_TWO("22", "사이다", 1000);

    private final String selection;
    private final String menu;
    private final int price;

    MenuSelection(String selection, String menu, int price) {
        this.selection = selection;
        this.menu = menu;
        this.price = price;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(MenuSelection.values())
                .anyMatch(menuSelection -> menuSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }
}
