package view;

import constant.ErrorMessage;
import constant.Message;
import java.util.Arrays;

public enum MainScreenSelection {
    ONE("1", "주문등록"),
    TWO("2", "결제하기"),
    THREE("3", "프로그램 종료");

    private final String selection;
    private final String content;

    MainScreenSelection(String selection, String content) {
        this.selection = selection;
        this.content = content;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(MainScreenSelection.values())
                .anyMatch(mainScreenSelection -> mainScreenSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

    public String toKorean() {
        return String.format(Message.SELECTION_MESSAGE_FORM, selection, content);
    }

    public String getSelection() {
        return selection;
    }

}
