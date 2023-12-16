package oncall.util;


import static oncall.util.Day.FRIDAY;
import static oncall.util.Day.MONDAY;
import static oncall.util.Day.SATURDAY;
import static oncall.util.Day.SUNDAY;
import static oncall.util.Day.THURSDAY;
import static oncall.util.Day.TUESDAY;
import static oncall.util.Day.WEDNESDAY;

import java.util.List;

public enum Week {

    WEEK(List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY)),
    WEEKEND(List.of(SATURDAY, SUNDAY));

    private final List<Day> days;

    Week(List<Day> days) {
        this.days = days;
    }

}
