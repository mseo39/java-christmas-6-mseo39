package model.event;

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
}
