package model.event;

import model.calendar.December;
import model.menu.ChristmasMenu;
import model.menu.Drink;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChristmasEvent {
    final private static Integer christmasDDayDiscountPeriodStart = 1;
    final private static Integer christmasDDayDiscountPeriodEnd = 25;
    final private static Integer christmasDDayDiscountInitPrice = 1000;
    final private static Integer christmasDDayDiscountStepPrice = 100;
    final private static Integer weekdayPerDessertDiscount = 2023;
    final private static Integer weekendPerMainDiscount = 2023;
    final private static Integer starDayDiscount = 1000;
    final private static Integer giveChampagnePrice = 120000;

    private ChristmasEvent() {

    }

    public static Integer getChristmasDDayDiscountInitPrice() {
        return christmasDDayDiscountInitPrice;
    }

    public static Integer getChristmasDDayDiscountStepPrice() {
        return christmasDDayDiscountStepPrice;
    }

    public static Integer getGiveChampagnePrice() {
        return giveChampagnePrice;
    }

    public static Map<String, Integer> ResultChristmasDDayDiscount(int day, int total, Map<String, Integer> order) {
        Map<String, Object> dayData = December.getDate(day);

        Map<String, Integer> discount = new LinkedHashMap<>();

        applyChristmasDDayDiscount(day, dayData, discount);
        applyWeekendDiscount(dayData, order, discount);
        applyWeekdayDiscount(dayData, order, discount);
        applySpecialDiscount(dayData, discount);
        applyGiveChampagneEvent(total, discount);

        return discount;
    }

    public static void applyChristmasDDayDiscount(int day, Map<String, Object> dayData, Map<String, Integer> discount) {
        if (christmasDDayDiscountPeriodStart <= day && christmasDDayDiscountPeriodEnd >= day) {
            discount.put("크리스마스 디데이 할인", (Integer) dayData.get("할인금액"));
        }
    }
    public static void applyWeekdayDiscount(Map<String, Object> dayData, Map<String, Integer> order, Map<String, Integer> discount) {
        if (dayData.get("엽업일").equals("평일")) {
            int count = ChristmasMenu.getCountForDessert(order);
            if (count != 0) {
                discount.put("평일 할인", count * weekdayPerDessertDiscount);
            }
        }
    }

    public static void applyWeekendDiscount(Map<String, Object> dayData, Map<String, Integer> order, Map<String, Integer> discount) {
        if (dayData.get("엽업일").equals("주말")) {
            int count = ChristmasMenu.getCountForMain(order);
            if (count != 0) {
                discount.put("주말 할인", count * weekdayPerDessertDiscount);
            }
        }
    }

    public static void applySpecialDiscount(Map<String, Object> dayData, Map<String, Integer> discount) {
        if (Boolean.parseBoolean(String.valueOf(dayData.get("별유무")))) {
            discount.put("특별 할인", starDayDiscount);
        }
    }

    public static void applyGiveChampagneEvent(int total, Map<String, Integer> discount) {
        if (giveChampagnePrice <= total) {
            discount.put("증정 이벤트", Drink.CHAMPAGNE.getPrice());
        }
    }
}