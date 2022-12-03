package service;

import constant.ErrorMessage;
import domain.Table;
import domain.TableRepository;
import dto.OrderHistory;
import java.util.List;

public class PaymentService {

    public List<OrderHistory> findOrderHistory(int tableNumber) {
        Table table = TableRepository.findTableByNumber(tableNumber);
        if (table.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_TABLE);
        }
        return table.createOrderHistory();
    }

    public int computeFinalPrice(int tableNumber, int payMethod) {
        Table table = TableRepository.findTableByNumber(tableNumber);
        int finalPrice = table.computeFinalPrice(payMethod);
        table.clear();
        return finalPrice;
    }
}
