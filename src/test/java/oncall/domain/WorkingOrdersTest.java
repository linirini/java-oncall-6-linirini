package oncall.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkingOrdersTest {

    @DisplayName("5자 이상인 닉네임이 존재하면 예외를 던진다.")
    @Test
    void 이름_길이_예외() {
        assertThatThrownBy(() -> new WorkingOrders(List.of("가나", "가나다라마바"))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("중복된 닉네임이 존재하면 예외를 던진다.")
    @Test
    void 이름_중복_예외() {
        assertThatThrownBy(() -> new WorkingOrders(List.of("가나", "마바", "가나"))).isInstanceOf(
                IllegalArgumentException.class);
    }

}