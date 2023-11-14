package controller;

import model.User.ChristmasUser;
import view.OutputView;

public class ChristmasController {
    private static ChristmasUser user;

    public ChristmasController() {
        user = new ChristmasUser();
    }

    public static void requestSection() {
        OutputView.printSection();
    }
}
