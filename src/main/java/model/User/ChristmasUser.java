package model.User;

import model.menu.ChristmasMenu;

import java.util.Map;

public class ChristmasUser {
    private int month = 12;
    private int day;
    private Map<String, Integer> order;
    private int totalPrice = 0;
    private int totalDiscount = 0;

    public void setDate(int day) {
        this.day = day;
    }

    public void setOrder(Map<String, Integer> order) {
        this.order = order;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalDiscount(int totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Map<String, Integer> getOrder() {
        return order;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public void sumAmountBefore() {
        int price = 0;
        for (Map.Entry<String, Integer> entry : this.getOrder().entrySet()) {
            price += ChristmasMenu.sumAppetizer(entry.getKey(), entry.getValue());
            price += ChristmasMenu.sumDessert(entry.getKey(), entry.getValue());
            price += ChristmasMenu.sumDrink(entry.getKey(), entry.getValue());
            price += ChristmasMenu.sumMain(entry.getKey(), entry.getValue());
        }
        this.setTotalPrice(price);
    }
}
