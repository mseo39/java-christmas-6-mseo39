package model.calendar;

import model.event.ChristmasEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class December {
    static private Map<Integer, Map<String, Object>> date = new HashMap<>();
    static private ArrayList<Integer> weekend = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(8);
        add(9);
        add(15);
        add(16);
        add(22);
        add(23);
        add(29);
        add(30);
    }};

    static private ArrayList<Integer> starDay = new ArrayList<Integer>() {{
        add(3);
        add(10);
        add(17);
        add(24);
        add(25);
        add(31);
    }};

    public static Map<String, Object> getDate(int day) {
        return date.get(day);
    }

    private December() {
    }

    public static void init() {
        initializeChristmasDiscountDates();
        initializeDefaultDiscountDates();
    }

    private static void initializeChristmasDiscountDates() {
        int price = ChristmasEvent.getChristmasDDayDiscountInitPrice();
        int stepPrice = ChristmasEvent.getChristmasDDayDiscountStepPrice();

        for (int i = 1; i < 32; i++) {
            Map<String, Object> tmpData = createDiscountDate(price, i);
            date.put(i, tmpData);
            price += stepPrice;
        }
    }

    private static void initializeDefaultDiscountDates() {
        for (int i = 26; i < 32; i++) {
            Map<String, Object> tmpData = createDiscountDate(0, i);
            date.put(i, tmpData);
        }
    }

    private static Map<String, Object> createDiscountDate(int price, int day) {
        Map<String, Object> tmpData = new HashMap<>();
        tmpData.put("할인금액", price);
        tmpData.put("영업일", getDayType(day));
        tmpData.put("별유무", isStar(day));
        return tmpData;
    }

    public static String getDayType(Integer day) {
        if (weekend.contains(day)) {
            return "주말";
        }
        return "평일";
    }

    public static boolean isStar(Integer day) {
        if (starDay.contains(day)) {
            return true;
        }
        return false;
    }
}
