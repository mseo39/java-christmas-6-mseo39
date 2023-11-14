package exception;

import model.menu.*;

import java.util.Map;

public class OrderMenu {
    private OrderMenu() {

    }

    public static String[] menuFormat(String input) {
        String[] itemInfo = input.split("-");

        if (itemInfo.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        return itemInfo;
    }

    public static int menuQuantityValid(String input) {
        int num = InputValid.stringToInteger(input, "주문");
        if (num < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        return num;
    }

    public static void menuValid(String menuName) {
        if (!ChristmasMenu.isValidAppetizer(menuName) &&
                !ChristmasMenu.isValidDessert(menuName) &&
                !ChristmasMenu.isValidDrink(menuName) &&
                !ChristmasMenu.isValidMain(menuName)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void menuDuplication(Map<String, Integer> order, String menuName) {
        if (order.containsKey(menuName)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
