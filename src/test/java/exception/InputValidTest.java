package exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidTest extends NsTest {

    @Test
    void 입력이_정수인지_확인(){
        assertThatThrownBy(() ->InputValid.stringToInteger("a","주문"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
