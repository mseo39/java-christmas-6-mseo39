package model.menu;

import java.util.Map;

public class ChristmasMenu {
    private ChristmasMenu() {

    }

    public static int sumAppetizer(String menuName, int num) {
        for (Appetizer menu : Appetizer.values()) {
            if (menu.getName().equals(menuName)) {
                return menu.getPrice() * num;
            }
        }
        return 0;
    }

    public static int sumDessert(String menuName, int num) {
        for (Dessert menu : Dessert.values()) {
            if (menu.getName().equals(menuName)) {
                return menu.getPrice() * num;
            }
        }
        return 0;
    }

    public static int sumDrink(String menuName, int num) {
        for (Drink menu : Drink.values()) {
            if (menu.getName().equals(menuName)) {
                return menu.getPrice() * num;
            }
        }
        return 0;
    }

    public static int sumMain(String menuName, int num) {
        for (Main menu : Main.values()) {
            if (menu.getName().equals(menuName)) {
                return menu.getPrice() * num;
            }
        }
        return 0;
    }

    public static boolean isValidAppetizer(String menuName) {
        for (Appetizer menu : Appetizer.values()) {
            if (menu.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidDessert(String menuName) {
        for (Dessert menu : Dessert.values()) {
            if (menu.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidDrink(String menuName) {
        for (Drink menu : Drink.values()) {
            if (menu.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidMain(String menuName) {
        for (Main menu : Main.values()) {
            if (menu.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }
    public static int getCountForDessert(Map<String, Integer> order) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            if (ChristmasMenu.isValidDessert(entry.getKey())) {
                count += entry.getValue();
            }
        }
        return count;
    }

    public static int getCountForMain(Map<String, Integer> order) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            if (ChristmasMenu.isValidMain(entry.getKey())) {
                count += entry.getValue();
            }
        }
        return count;
    }
}