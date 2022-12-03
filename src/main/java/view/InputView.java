package view;

import constant.Message;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static void printTitleMessage(String selectionTitle) {
        System.out.printf(Message.TITLE_MESSAGE_FORM, selectionTitle);
        System.out.println();
    }

    private static void printSelectFunction() {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, Message.SELECT_FUNCTION);
        System.out.println();
    }

    public static String requestMainScreenSelection() {
        System.out.println();
        printTitleMessage(Message.MAIN_SCREEN);
        Arrays.stream(MainScreenSelection.values())
                .map(MainScreenSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String mainScreenSelection = scanner.nextLine();
        MainScreenSelection.validate(mainScreenSelection);
        return mainScreenSelection;
    }

    public static String requestTableNumber() {
        System.out.println();
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        System.out.println();
        printTitleMessage(Message.REQUEST_TABLE_NUMBER);
        String tableNumber = scanner.nextLine();
        TableNumberSelection.validate(tableNumber);
        return tableNumber;
    }

    public static String requestMenuNumber() {
        System.out.println();
        List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        System.out.println();
        printTitleMessage(Message.REQUEST_REGISTER_MENU);
        String menuNumber = scanner.nextLine();
        MenuSelection.validate(menuNumber);
        return menuNumber;
    }

    public static int requestMenuQuantity() {
        System.out.println();
        printTitleMessage(Message.REQUEST_MENU_QUANTITY);
        int menuQuantity = scanner.nextInt();
        scanner.nextLine();
        return menuQuantity;
    }

    public static String requestPaymentMethod() {
        printTitleMessage(Message.PAYMENT_METHOD);
        String paymentMethod = scanner.nextLine();
        PaymentMethod.validate(paymentMethod);
        return paymentMethod;
    }
}
