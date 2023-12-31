package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import model.event.ChristmasEvent;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

public class ChristmasEventTest extends NsTest {
    @Test
    void 크리스마스디데이할인_적용_테스트() {
        Map<String, Integer> discount = new HashMap<>();
        Map<String, Object> dayData = new HashMap<>();
        dayData.put("할인금액", 3400);
        dayData.put("엽업일", " 평일");
        dayData.put("별유무", true);

        ChristmasEvent.applyChristmasDDayDiscount(25, dayData, discount);

        assertThat(discount.get("크리스마스 디데이 할인")).isEqualTo(3400);
    }

    @Test
    void 크리스마스디데이할인_범위_벗어난_테스트() {
        Map<String, Integer> discount = new HashMap<>();
        Map<String, Object> dayData = new HashMap<>();
        dayData.put("할인금액", 0);
        dayData.put("엽업일", "평일");
        dayData.put("별유무", true);

        ChristmasEvent.applyChristmasDDayDiscount(26, dayData, discount);

        assertThat(discount.size()).isEqualTo(0);
    }

    @Test
    void 평일할인_적용() {
        Map<String, Integer> discount = new HashMap<>();
        Map<String, Object> dayData = new HashMap<>();
        dayData.put("엽업일", "평일");

        Map<String, Integer> order = new HashMap<>();
        order.put("양송이수프", 1);
        order.put("초코케이크", 3);
        order.put("아이스크림", 1);

        ChristmasEvent.applyWeekdayDiscount(dayData, order, discount);

        assertThat(discount.get("평일 할인")).isEqualTo(8092);
    }

    @Test
    void 평일할인_미적용() {
        Map<String, Integer> discount = new HashMap<>();
        Map<String, Object> dayData = new HashMap<>();
        dayData.put("엽업일", "주말");

        Map<String, Integer> order = new HashMap<>();
        order.put("양송이수프", 1);
        order.put("초코케이크", 3);
        order.put("아이스크림", 1);

        ChristmasEvent.applyWeekdayDiscount(dayData, order, discount);

        assertThat(discount.size()).isEqualTo(0);
    }

    @Test
    void 주말할인_적용() {
        Map<String, Integer> discount = new HashMap<>();
        Map<String, Object> dayData = new HashMap<>();
        dayData.put("엽업일", "주말");

        Map<String, Integer> order = new HashMap<>();
        order.put("티본스테이크", 3);
        order.put("초코케이크", 3);
        order.put("아이스크림", 1);

        ChristmasEvent.applyWeekendDiscount(dayData, order, discount);

        assertThat(discount.get("주말 할인")).isEqualTo(6069);
    }

    @Test
    void 주말할인_미적용() {
        Map<String, Integer> discount = new HashMap<>();
        Map<String, Object> dayData = new HashMap<>();
        dayData.put("엽업일", "평일");

        Map<String, Integer> order = new HashMap<>();
        order.put("티본스테이크", 3);
        order.put("초코케이크", 3);
        order.put("아이스크림", 1);

        ChristmasEvent.applyWeekendDiscount(dayData, order, discount);

        assertThat(discount.size()).isEqualTo(0);
    }

    @Test
    void 특별할인_적용() {
        Map<String, Integer> discount = new HashMap<>();
        Map<String, Object> dayData = new HashMap<>();
        dayData.put("별유무", true);

        ChristmasEvent.applySpecialDiscount(dayData, discount);

        assertThat(discount.get("특별 할인")).isEqualTo(1000);
    }

    @Test
    void 특별할인_미적용() {
        Map<String, Integer> discount = new HashMap<>();
        Map<String, Object> dayData = new HashMap<>();
        dayData.put("별유무", false);

        ChristmasEvent.applySpecialDiscount(dayData, discount);

        assertThat(discount.size()).isEqualTo(0);
    }

    @Test
    void 증정이벤트_적용() {
        Map<String, Integer> discount = new HashMap<>();

        ChristmasEvent.applyGiveChampagneEvent(120000, discount);

        assertThat(discount.get("증정 이벤트")).isEqualTo(25000);
    }

    @Test
    void 증정이벤트_미적용() {
        Map<String, Integer> discount = new HashMap<>();

        ChristmasEvent.applyGiveChampagneEvent(110000, discount);

        assertThat(discount.size()).isEqualTo(0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
