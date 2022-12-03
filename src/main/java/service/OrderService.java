package service;

import domain.Table;
import domain.TableRepository;

public class OrderService {

    public void order(int tableNumber, int menuNumber, int menuQuantity) {
        Table table = TableRepository.findTableByNumber(tableNumber);
        table.order(menuNumber, menuQuantity);
    }
}
