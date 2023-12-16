package oncall.util.calender;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MonthTest {

    @Test
    void 숫자로_월_반환() {
        assertThat(Month.getMonth("5")).isEqualTo(Month.MAY);
    }

}