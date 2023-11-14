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
}
