package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;

import oncall.util.Day;
import oncall.util.Month;
import org.junit.jupiter.api.Test;

class CalenderTest {

    @Test
    void 주말이다() {
        assertThat(new Calender(Month.DECEMBER, Day.WEDNESDAY).isWeekend(5)).isTrue();
    }

    @Test
    void 평일_공휴일_이다() {
        assertThat(new Calender(Month.MARCH, Day.MONDAY).isWeekend(1)).isTrue();
    }

    @Test
    void 평일이다() {
        assertThat(new Calender(Month.DECEMBER, Day.WEDNESDAY).isWeekend(6)).isFalse();
    }

}