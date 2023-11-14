package model.menu;

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
}