package controller;

import dto.OrderHistory;
import java.util.List;
import service.PaymentService;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class PaymentController {

    private final PaymentService paymentService = new PaymentService();

    public void run() {
        String tableNumber = Utils.requestInput(InputView::requestTableNumber, OutputView::printErrorMessage);
        List<OrderHistory> orderHistory = paymentService.findOrderHistory(Integer.parseInt(tableNumber));
        OutputView.printOrderHistory(orderHistory);
        OutputView.printPaymentProgress(Integer.parseInt(tableNumber));
        String paymentMethod = Utils.requestInput(InputView::requestPaymentMethod, OutputView::printErrorMessage);
        int finalPrice = paymentService.computeFinalPrice(Integer.parseInt(tableNumber), Integer.parseInt(paymentMethod));

    }
}
