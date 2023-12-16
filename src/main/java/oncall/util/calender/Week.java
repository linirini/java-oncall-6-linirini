package oncall.util.calender;


import static oncall.util.calender.Day.FRIDAY;
import static oncall.util.calender.Day.MONDAY;
import static oncall.util.calender.Day.SATURDAY;
import static oncall.util.calender.Day.SUNDAY;
import static oncall.util.calender.Day.THURSDAY;
import static oncall.util.calender.Day.TUESDAY;
import static oncall.util.calender.Day.WEDNESDAY;

import java.util.List;

public enum Week {

    WEEK(List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY)),
    WEEKEND(List.of(SATURDAY, SUNDAY));

    private final List<Day> days;

    Week(List<Day> days) {
        this.days = days;
    }

}
