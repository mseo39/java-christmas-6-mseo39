package model.menu;

public enum Dessert {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private String name = "";
    private int price = 0;

    Dessert(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
