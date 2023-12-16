package oncall.util;

import static oncall.util.Constants.FRIDAY;
import static oncall.util.Constants.MONDAY;
import static oncall.util.Constants.SATURDAY;
import static oncall.util.Constants.SUNDAY;
import static oncall.util.Constants.THURSDAY;
import static oncall.util.Constants.TUESDAY;
import static oncall.util.Constants.WEDNESDAY;

import java.util.List;

public enum Day {

    WEEK(List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY)),
    WEEKEND(List.of(SATURDAY, SUNDAY));

    private final List<String> days;

    Day(List<String> days) {
        this.days = days;
    }
}
