package oncall.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @Test
    void 같은_순번_예외() {
        assertThatThrownBy(
                () -> new Orders(new WorkingOrders(List.of("가나", "다라", "마바", "사아", "자차")),
                        new WorkingOrders(List.of("가나", "다라", "마바", "사아", "자차")))).isInstanceOf(
                IllegalArgumentException.class);
    }

}