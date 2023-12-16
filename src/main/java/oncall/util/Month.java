package oncall.util;

import static oncall.util.ExceptionEnum.INVALID_MONTH;

import java.util.Arrays;

public enum Month {

    JANUARY(1,31),
    FEBRUARY(2,28),
    MARCH(3,31),
    APRIL(4,30),
    MAY(5,31),
    JUNE(6,30),
    JULY(7,31),
    AUGUST(8,31),
    SEPTEMBER(9,30),
    OCTOBER(10,31),
    NOVEMBER(11,30),
    DECEMBER(12,31);

    private final int month;
    private final int lastDate;

    Month(int month, int lastDate) {
        this.month = month;
        this.lastDate = lastDate;
    }

    public static Month getMonth(int month) {
        return Arrays.stream(values()).filter(monthEnum -> month == monthEnum.month).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MONTH.getMessage()));
    }

}
