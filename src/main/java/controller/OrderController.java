package controller;

import service.OrderService;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class OrderController {

    private final OrderService orderService = new OrderService();

    public void run() {
        String tableNumber = Utils.requestInput(InputView::requestTableNumber, OutputView::printErrorMessage);
        String menuNumber = Utils.requestInput(InputView::requestMenuNumber, OutputView::printErrorMessage);
        int menuQuantity = InputView.requestMenuQuantity();
        try {
            orderService.order(Integer.parseInt(tableNumber), Integer.parseInt(menuNumber), menuQuantity);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
