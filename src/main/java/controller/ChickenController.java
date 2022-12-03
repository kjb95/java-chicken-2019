package controller;

import java.util.HashMap;
import java.util.Map;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class ChickenController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();

    public ChickenController() {

    }

    public void run() {
        String mainScreenSelection = Utils.requestInput(InputView::requestMainScreenSelection, OutputView::printErrorMessage);

    }
}
