package view;

import model.event.Badge;

import java.util.Map;
import java.text.DecimalFormat;

public class OutputView {
    private OutputView() {

    }

    public static void printGreeting() {
        System.out.println(Phrase.GREETING.getPhrase());
    }

    public static void printBenefitsGuide(int month, int day) {
        System.out.println(String.format(Phrase.BENEFITS_GUIDE.getPhrase(), month, day));
    }

    public static void printMenu(Map<String, Integer> order) {
        System.out.println(Phrase.ORDER_MENU.getPhrase());
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
    }

    public static String formatNumber(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }

    public static void printTotalOrderAmountBefore(int price) {
        System.out.println(Phrase.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getPhrase());
        System.out.println(formatNumber(price) + "원");
    }

    public static void printGiftMenu(String result) {
        System.out.println(Phrase.GIFT_MENU.getPhrase());
        System.out.println(result);
    }

    public static void printBenefitsDetails(Map<String, Integer> benefit, int price) {
        System.out.println(Phrase.BENEFITS_DETAILS.getPhrase());
        if (benefit.size() == 0 || price<10000) {
            System.out.println("없음");
            return;
        }
        for (Map.Entry<String, Integer> entry : benefit.entrySet()) {
            System.out.println(entry.getKey() + ": -" + formatNumber(entry.getValue()) + "원");
        }
    }

    public static void printTotalBenefit(int price) {
        System.out.println(Phrase.TOTAL_BENEFITS_DETAILS.getPhrase());
        if(price==0){
            System.out.println(price + "원");
            return;
        }
        System.out.println("-" + formatNumber(price) + "원");
    }

    public static void printEstimatedAmountAfter(int price) {
        System.out.println(Phrase.ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT.getPhrase());
        System.out.println(formatNumber(price) + "원");
    }

    public static void printEventBadge(int price) {
        System.out.println(Phrase.EVENT_BADGE.getPhrase());
        System.out.println(Badge.getBadgeType(price));
    }
    public static void printSection() {
        System.out.println("");
    }

}
