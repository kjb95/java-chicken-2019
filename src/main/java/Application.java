import controller.ChickenController;

public class Application {

    // TODO 구현 진행
    public static void main(String[] args) {
        ChickenController chickenController = new ChickenController();
        chickenController.run();

        //        final List<Table> tables = TableRepository.tables();
        //        OutputView.printTables(tables);
        //
        //        final int tableNumber = InputView.inputTableNumber();
        //
        //        final List<Menu> menus = MenuRepository.menus();
        //        OutputView.printMenus(menus);
    }
}
