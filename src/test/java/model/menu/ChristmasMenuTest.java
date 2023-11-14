package model.menu;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChristmasMenuTest extends NsTest {

    @Test
    void 애피타이저_총가격_테스트() {
        int totalPrice = ChristmasMenu.sumAppetizer("양송이수프", 3);
        assertThat(totalPrice).isEqualTo(18000);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
