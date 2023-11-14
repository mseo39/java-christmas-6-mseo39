package model.event;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
