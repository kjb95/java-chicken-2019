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

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    private static void printTitleMessage(String selectionTitle) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, selectionTitle);
        System.out.println();
    }

    private static void printSelectFunction() {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, Message.SELECT_FUNCTION);
        System.out.println();
    }

    public static String requestMainScreenSelection() {
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
        printTitleMessage(Message.REQUEST_TABLE_NUMBER);
        String tableNumber = scanner.nextLine();
        TableNumberSelection.validate(tableNumber);
        return tableNumber;
    }

    public static String requestMenuNumber() {
        System.out.println();
        List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        printTitleMessage(Message.REQUEST_REGISTER_MENU);
        String menuNumber = scanner.nextLine();
        MenuSelection.validate(menuNumber);
        return menuNumber;
    }

    public static int requestMenuQuantity() {
        printTitleMessage(Message.REQUEST_MENU_QUANTITY);
        int menuQuantity = scanner.nextInt();
        scanner.nextLine();
        return menuQuantity;
    }
}
