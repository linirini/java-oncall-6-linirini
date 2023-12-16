package oncall.domain;

import java.util.List;
import oncall.util.Calender;

public class WorkSchedule {

    private final Calender calender;
    private final List<String> schedules;

    public WorkSchedule(Calender calender, List<String> schedules) {
        this.calender = calender;
        this.schedules = schedules;
    }

}
