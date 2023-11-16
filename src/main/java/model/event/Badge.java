package model.event;

public enum Badge {
    STAR(5000),
    TREE(10000),
    SANTA(20000);

    private int price = 0;

    Badge(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static String getBadgeType(int price) {
        if (SANTA.getPrice() <= price) {
            return "산타";
        }
        if (TREE.getPrice() <= price) {
            return "트리";
        }
        if (STAR.getPrice() <= price) {
            return "별";
        }

        return "없음";
    }
}
