package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;

import oncall.util.calender.Day;
import oncall.util.calender.Month;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalenderTest {

    @ParameterizedTest
    @ValueSource(ints={1,2,8,9,15,16,22,23,29,30})
    void 주말이다(int date) {
        assertThat(new Calender(Month.APRIL, Day.SATURDAY).isWeekend(date)).isTrue();
    }

    @Test
    void 평일이다() {
        assertThat(new Calender(Month.DECEMBER, Day.WEDNESDAY).isWeekend(6)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"1,금","16,토","25,월","13,수","14,목"})
    void 날짜로_요일_반환(int date, String day) {
        assertThat(new Calender(Month.DECEMBER, Day.FRIDAY).getDay(date)).isEqualTo(day);
    }

}