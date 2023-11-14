package controller;

import model.User.ChristmasUser;
import view.InputView;
import view.OutputView;

public class ChristmasController {
    private static ChristmasUser user;

    public ChristmasController() {
        user = new ChristmasUser();
    }

    public static void requestSection() {
        OutputView.printSection();
    }

    public static void requestGreeting() {
        OutputView.printGreeting();
    }

    public void requestReadDate() {
        user.setDate(InputView.readDate());
    }

    public void requestReadMenu() {
        user.setOrder(InputView.readMenu());
    }

    public static void requestPrintGuide() {
        OutputView.printBenefitsGuide(user.getMonth(), user.getDay());
    }

    public void requestPrintMenu() {
        OutputView.printMenu(user.getOrder());
    }
}
