package oncall.util.calender;

import static oncall.util.calender.Month.AUGUST;
import static oncall.util.calender.Month.DECEMBER;
import static oncall.util.calender.Month.JANUARY;
import static oncall.util.calender.Month.JUNE;
import static oncall.util.calender.Month.MARCH;
import static oncall.util.calender.Month.MAY;
import static oncall.util.calender.Month.OCTOBER;

import java.util.Arrays;

public enum Holiday {

    NEW_YEARS_DAY(JANUARY, 1, "신정"),
    INDEPENDENCE_MOVEMENT_DAY(MARCH, 1, "삼일절"),
    CHILDREN_DAY(MAY, 5, "어린이날"),
    MEMORIAL_DAY(JUNE, 6, "현충일"),
    INDEPENDENCE_DAY(AUGUST, 15, "광복절"),
    FOUNDATION_DAY(OCTOBER, 3, "개천절"),
    KOREAN_DAY(OCTOBER, 9, "한글날"),
    CHRISTMAS(DECEMBER, 25, "성탄절");

    private final Month month;
    private final int date;

    private final String name;

    Holiday(Month month, int date, String name) {
        this.month = month;
        this.date = date;
        this.name = name;
    }

    public static boolean isHoliday(Month month, int date) {
        return Arrays.stream(values())
                .anyMatch(holiday -> holiday.month == month && holiday.date == date);
    }

}
