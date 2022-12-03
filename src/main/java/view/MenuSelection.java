package view;

import constant.ErrorMessage;
import java.util.Arrays;

public enum MenuSelection {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    TWENTY_ONE("21"),
    TWENTY_TWO("22");

    private final String selection;

    MenuSelection(String selection) {
        this.selection = selection;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(MenuSelection.values())
                .anyMatch(menuSelection -> menuSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }
}
