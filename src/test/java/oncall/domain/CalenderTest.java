package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;

import oncall.util.calender.Day;
import oncall.util.calender.Month;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalenderTest {

    @Test
    void 주말이다() {
        assertThat(new Calender(Month.DECEMBER, Day.WEDNESDAY).isWeekend(5)).isTrue();
    }

    @Test
    void 평일이다() {
        assertThat(new Calender(Month.DECEMBER, Day.WEDNESDAY).isWeekend(6)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"16,토","25,월","13,수"})
    void 날짜로_요일_반환(int date, String day) {
        assertThat(new Calender(Month.DECEMBER, Day.FRIDAY).getDay(date)).isEqualTo(day);
    }

}