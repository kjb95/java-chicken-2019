package view;

import constant.ErrorMessage;
import java.util.Arrays;

public enum PaymentMethod {
    ONE("1"),
    TWO("2");

    private final String selection;

    PaymentMethod(String selection) {
        this.selection = selection;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(PaymentMethod.values())
                .anyMatch(paymentMethod -> paymentMethod.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }
}
