package controller;

import java.util.HashMap;
import java.util.Map;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class OrderController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();

    public void run() {
        String stationManageSelection = Utils.requestInput(InputView::requestTableNumber, OutputView::printErrorMessage);

    }
}
