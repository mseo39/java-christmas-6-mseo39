package exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    void 수량1개미만일때_테스트() {
        assertThatThrownBy(() -> OrderMenu.menuQuantityValid("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수량1개이상일때_테스트() {
        int result = OrderMenu.menuQuantityValid("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 없는메뉴일때_테스트() {
        assertThatThrownBy(() -> OrderMenu.menuValid("초코우유"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴중복일때_테스트() {
        Map<String, Integer> order = new HashMap<>();
        order.put("초코케이크", 1);
        order.put("제로콜라", 1);

        assertThatThrownBy(() -> OrderMenu.menuDuplication(order, "초코케이크"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 총수량_20넘을때_테스트() {
        Map<String, Integer> order = new HashMap<>();
        order.put("초코케이크", 1);
        order.put("제로콜라", 20);

        assertThatThrownBy(() -> OrderMenu.maxNumMenu(order))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
