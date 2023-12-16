package oncall.util;

import static oncall.util.ExceptionEnum.INVALID_MONTH;

import java.util.Arrays;

public enum Calender {

    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private final int month;

    Calender(int month) {
        this.month = month;
    }

    public static Calender getMonth(int month) {
        return Arrays.stream(values()).filter(monthEnum -> month == monthEnum.month).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MONTH.getMessage()));
    }

}
