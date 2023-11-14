package model.calendar;

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
}
