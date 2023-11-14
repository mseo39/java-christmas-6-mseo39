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
}
