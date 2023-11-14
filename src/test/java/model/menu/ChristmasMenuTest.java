package model.menu;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ChristmasMenuTest extends NsTest {

    @Test
    void 애피타이저_총가격_테스트() {
        int totalPrice = ChristmasMenu.sumAppetizer("양송이수프", 3);
        assertThat(totalPrice).isEqualTo(18000);
    }

    @Test
    void 메뉴가_애피타이저맞는지_테스트() {
        boolean isAppetizer = ChristmasMenu.isValidAppetizer("양송이수프");
        assertThat(isAppetizer).isTrue();
    }

    @Test
    void 메뉴가_애피타이저가_아닐때_테스트() {
        boolean isAppetizer = ChristmasMenu.isValidAppetizer("제로콜라");
        assertThat(isAppetizer).isFalse();
    }

    @Test
    void 디저트개수_확인_테스트() {
        Map<String, Integer> order = new HashMap<>();
        order.put("양송이수프", 1);
        order.put("초코케이크", 3);
        order.put("아이스크림", 1);

        int count = ChristmasMenu.getCountForDessert(order);
        assertThat(count).isEqualTo(4);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
