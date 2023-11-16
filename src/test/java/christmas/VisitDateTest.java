package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import exception.VisitDate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VisitDateTest extends NsTest {

    @Test
    void 날짜입력_문자일때_테스트() {
        assertThatThrownBy(() -> VisitDate.checkDate("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 날짜입력_범위벗어날때_테스트() {
        assertThatThrownBy(() -> VisitDate.checkDate("32"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
