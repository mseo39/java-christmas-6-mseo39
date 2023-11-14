package view;

import camp.nextstep.edu.missionutils.Console;
import exception.OrderMenu;
import exception.VisitDate;

import java.util.HashMap;
import java.util.Map;

public class InputView {

    private InputView() {

    }

    public static int readDate() {
        int result = 0;

        while (true) {
            System.out.println(Phrase.INPUT_VISIT_DATE.getPhrase());
            String input = Console.readLine();
            try {
                result = VisitDate.checkDate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}