package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import model.user.ChristmasUser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

public class ChristmasUserTest extends NsTest {

    @Test
    void 총가격_계산() {
        Map<String, Integer> order = new HashMap<>();
        order.put("티본스테이크", 1);
        order.put("레드와인", 2);

        ChristmasUser christmasUser = new ChristmasUser();
        christmasUser.setOrder(order);
        christmasUser.sumAmountBefore();

        assertThat(christmasUser.getTotalPrice()).isEqualTo(175000);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
