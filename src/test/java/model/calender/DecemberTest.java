package model.calender;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import model.calendar.December;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class DecemberTest extends NsTest {

    @Test
    void 평일주말구분_평일일때_테스트() {
        String dayType = December.getDayType(3);
        assertThat(dayType).isEqualTo("평일");
    }

    @Test
    void 평일주말구분_주말일때_테스트() {
        String dayType = December.getDayType(1);
        assertThat(dayType).isEqualTo("주말");
    }

    @Test
    void 별구분_별일때_테스트() {
        boolean result = December.isStar(3);
        assertThat(result).isTrue();
    }

    @Test
    void 별구분_별아닐때_테스트() {
        boolean result = December.isStar(1);
        assertThat(result).isFalse();
    }

    @Test
    void 달력초기화_테스트() {
        December.init();
        Map<String, Object> calender = December.getDate(3);
        assertThat(calender.get("할인금액")).isEqualTo(1200);
        assertThat(calender.get("영업일")).isEqualTo("평일");
        assertThat(calender.get("별유무")).isEqualTo(true);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
