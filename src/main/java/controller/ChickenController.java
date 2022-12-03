package controller;

import java.util.HashMap;
import java.util.Map;
import utils.Utils;
import view.InputView;
import view.MainScreenSelection;
import view.OutputView;

public class ChickenController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();

    public ChickenController() {
        OrderController orderController = new OrderController();
        selectionNavigator.put(MainScreenSelection.ONE.getSelection(), orderController::run);

    }

    public void run() {
        String mainScreenSelection = Utils.requestInput(InputView::requestMainScreenSelection, OutputView::printErrorMessage);
        if (mainScreenSelection.equals(MainScreenSelection.THREE.getSelection())) {
            return;
        }
        Runnable nextAction = selectionNavigator.get(mainScreenSelection);
        nextAction.run();
        run();
    }
}
