package oncall.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HolidayTest {

    @Test
    void 공휴일이다() {
        assertThat(Holiday.isHoliday(Month.OCTOBER, 9)).isTrue();
    }

    @Test
    void 공휴일아니다() {
        assertThat(Holiday.isHoliday(Month.DECEMBER, 9)).isFalse();
    }

}