package controller;

import model.user.ChristmasUser;
import model.calendar.December;
import model.event.ChristmasEvent;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class ChristmasController {
    private static ChristmasUser user;

    public ChristmasController() {
        user = new ChristmasUser();
    }

    public void startEvent() {
        December.init();
        requestGreeting();
        requestReadDate();
        requestReadMenu();
        requestPrintGuide();
        printEvent();
    }

    public void printEvent(){
        requestSection();
        requestPrintMenu();
        requestSection();
        requestPrintAmountBefore();
        requestSection();
        requestPrintGiftMenu();
        requestSection();
        requestPrintBenefitsDetails();
        requestSection();
        requestPrintTotalBenefit();
        requestSection();
        requestPrintEstimatedAmountAfter();
        requestSection();
        requestPrintBadge();
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

    public void requestPrintAmountBefore() {
        user.sumAmountBefore();
        OutputView.printTotalOrderAmountBefore(user.getTotalPrice());
    }

    public void requestPrintGiftMenu() {
        if (ChristmasEvent.getGiveChampagnePrice() <= user.getTotalPrice()) {
            OutputView.printGiftMenu("샴페인 1개");
            return;
        }
        OutputView.printGiftMenu("없음");
    }

    public void requestPrintBenefitsDetails() {
        Map<String, Integer> benefit = ChristmasEvent.ResultChristmasDDayDiscount(user.getDay(),
                user.getTotalPrice(),
                user.getOrder());
        OutputView.printBenefitsDetails(benefit, user.getTotalPrice());
        if (user.getTotalPrice()>=10000)
            user.setTotalDiscount(benefit.values().stream().mapToInt(Integer::intValue).sum());
    }

    public void requestPrintTotalBenefit() {
        OutputView.printTotalBenefit(user.getTotalDiscount());
    }
    public void requestPrintEstimatedAmountAfter() {
        if (ChristmasEvent.getGiveChampagnePrice() <= user.getTotalPrice()) {
            OutputView.printEstimatedAmountAfter(user.getTotalPrice() - user.getTotalDiscount() + 25000);
            return;
        }
        OutputView.printEstimatedAmountAfter(user.getTotalPrice() - user.getTotalDiscount());
    }

    public void requestPrintBadge() {
        OutputView.printEventBadge(user.getTotalDiscount());
    }

}
