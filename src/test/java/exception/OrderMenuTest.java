package exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderMenuTest extends NsTest {

    @Test
    void 주문형식_올바르지않을때_테스트() {
        assertThatThrownBy(() -> OrderMenu.menuFormat("제로콜라 1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주문형식_올바를때_테스트() {
        String[] itemInfo = OrderMenu.menuFormat("제로콜라-1");
        assertThat(itemInfo).contains("제로콜라", "1");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
