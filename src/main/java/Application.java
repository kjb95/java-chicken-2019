import controller.MainScreenController;

public class Application {

    private static final MainScreenController mainScreenController = MainScreenController.getInstance();

    // TODO 구현 진행
    public static void main(String[] args) {
        mainScreenController.run();
        //
        //        final List<Table> tables = TableRepository.tables();
        //        OutputView.printTables(tables);
        //
        //        final int tableNumber = InputView.inputTableNumber();
        //
        //
        //        final List<Menu> menus = MenuRepository.menus();
        //        OutputView.printMenus(menus);
    }
}
