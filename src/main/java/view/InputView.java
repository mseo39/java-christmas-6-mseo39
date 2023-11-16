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

    public static Map<String, Integer> readMenu() {
        System.out.println(Phrase.INPUT_MENU.getPhrase());
        Map<String, Integer> orderMap = processMenuInput();

        while (orderMap.isEmpty()) {
            orderMap = processMenuInput();
        }

        return orderMap;
    }

    private static Map<String, Integer> processMenuInput() {
        String input = Console.readLine();
        Map<String, Integer> orderMap = new HashMap<>();

        for (String item : input.split(",")) {
            try {
                processOrderItem(orderMap, item);
                checkOrderItem(orderMap);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                orderMap.clear();
                break;
            }
        }

        return orderMap;
    }

    private static void processOrderItem(Map<String, Integer> orderMap, String item) {
        String[] itemInfo = OrderMenu.menuFormat(item);
        OrderMenu.menuValid(itemInfo[0]);
        OrderMenu.menuDuplication(orderMap, itemInfo[0]);
        orderMap.put(itemInfo[0], OrderMenu.menuQuantityValid(itemInfo[1]));
    }

    private static void checkOrderItem(Map<String, Integer> orderMap) {
        OrderMenu.maxNumMenu(orderMap);
        OrderMenu.checkDrinkCount(orderMap);
    }
}