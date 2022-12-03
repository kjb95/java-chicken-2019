package service;

import domain.Table;
import domain.TableRepository;
import dto.OrderHistory;
import java.util.List;

public class PaymentService {

    public List<OrderHistory> findOrderHistory(int tableNumber) {
        Table table = TableRepository.findTableByNumber(tableNumber);
        return table.createOrderHistory();
    }
}
