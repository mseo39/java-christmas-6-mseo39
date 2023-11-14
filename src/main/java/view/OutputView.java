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
}
