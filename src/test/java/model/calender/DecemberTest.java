package model.calender;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import model.calendar.December;
import org.junit.jupiter.api.Test;

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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
