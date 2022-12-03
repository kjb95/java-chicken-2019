package view;

import constant.ErrorMessage;
import java.util.Arrays;

public enum TableNumberSelection {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FIVE("5"),
    SIX("6"),
    EIGHT("8");

    private final String selection;

    TableNumberSelection(String selection) {
        this.selection = selection;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(TableNumberSelection.values())
                .anyMatch(tableNumberSelection -> tableNumberSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

}
