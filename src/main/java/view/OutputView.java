package view;

import constant.ErrorMessage;
import constant.Message;
import domain.Menu;
import domain.Table;
import dto.OrderHistory;
import java.util.List;

public class OutputView {

    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println();
        System.out.printf(ErrorMessage.ERROR_MESSAGE_FORM, message);
        System.out.println();
    }

    public static void printOrderHistory(List<OrderHistory> orderHistory) {
        printTitleMessage(Message.ORDER_HISTORY);
        System.out.println(Message.MENU_QUANTITY_PRICE);
        orderHistory.forEach(System.out::println);
    }

    private static void printTitleMessage(String selectionTitle) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, selectionTitle);
        System.out.println();
    }

    public static void printPaymentProgress(int parseInt) {
        String paymentProgress = String.format(Message.PAYMENT_PROGRESS_FORM, parseInt);
        printTitleMessage(paymentProgress);
    }

    public static void printFinalPaymentAmount(int finalPrice) {
        printTitleMessage(Message.FINAL_PAYMENT_AMOUNT);
        System.out.printf(Message.PAYMENT_FORM, finalPrice);
        System.out.println();
    }
}
