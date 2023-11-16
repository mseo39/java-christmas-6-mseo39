package christmas;

import controller.ChristmasController;
import model.calendar.December;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController=new ChristmasController();
        christmasController.startEvent();
    }
}
