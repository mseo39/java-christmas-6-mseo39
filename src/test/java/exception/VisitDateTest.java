package exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VisitDateTest extends NsTest {

    @Test
    void 날짜입력_문자일때_테스트() {
        assertThatThrownBy(() -> VisitDate.checkDate("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
