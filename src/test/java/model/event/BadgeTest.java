package model.event;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTest extends NsTest {

    @Test
    void 산타배지반환_테스트() {
        String type = Badge.getBadgeType(20000);
        assertThat(type).isEqualTo("산타");
    }

    @Test
    void 트리배지반환_테스트() {
        String type = Badge.getBadgeType(10000);
        assertThat(type).isEqualTo("트리");
    }

    @Test
    void 별배지반환_테스트() {
        String type = Badge.getBadgeType(5000);
        assertThat(type).isEqualTo("별");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
