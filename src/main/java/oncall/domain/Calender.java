package oncall.domain;

import static oncall.util.calender.Day.SATURDAY;
import static oncall.util.calender.Day.SUNDAY;

import java.util.List;
import oncall.util.calender.Day;
import oncall.util.calender.Holiday;
import oncall.util.calender.Month;

public class Calender {

    private static final int FIRST_DAY = 1;
    private final Month month;
    private final Day startDay;
    private final List<Integer> firstWeekend;

    public Calender(Month month, Day startDay) {
        this.month = month;
        this.startDay = startDay;
        firstWeekend = getFirstWeekend(startDay);
    }

    private List<Integer> getFirstWeekend(Day startDay) {
        return List.of(getFirstSaturday(startDay), getFirstSunday(startDay));
    }

    private int getFirstSaturday(Day startDay) {
        return FIRST_DAY + Math.abs(startDay.getDaySequence() - SATURDAY.getDaySequence());
    }

    private static int getFirstSunday(Day startDay) {
        return FIRST_DAY + Math.abs(startDay.getDaySequence() - SUNDAY.getDaySequence());
    }

    public boolean isWeekend(int date) {
        return (date - this.firstWeekend.get(0)) % 7 == 0 || (date - this.firstWeekend.get(1) % 7
                == 0) || Holiday.isHoliday(month,date);
    }

    public int getLastDateOfMonth(){
        return month.getLastDate();
    }

}
