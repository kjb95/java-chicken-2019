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
        try {
            requestTableNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private void requestTableNumber() {
        String tableNumberString = Utils.requestInput(InputView::requestTableNumber, OutputView::printErrorMessage);
        int tableNumber = Integer.parseInt(tableNumberString);
        List<OrderHistory> orderHistory = paymentService.findOrderHistory(tableNumber);
        OutputView.printOrderHistory(orderHistory);
        OutputView.printPaymentProgress(tableNumber);
        String paymentMethod = Utils.requestInput(InputView::requestPaymentMethod, OutputView::printErrorMessage);
        int finalPrice = paymentService.computeFinalPrice(tableNumber, Integer.parseInt(paymentMethod));
        OutputView.printFinalPaymentAmount(finalPrice);
    }
}
