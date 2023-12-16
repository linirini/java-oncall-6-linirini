package oncall.domain;

import java.util.List;

public class WorkSchedule {

    private final Calender calender;
    private final List<String> schedules;

    public WorkSchedule(Calender calender, List<String> schedules) {
        this.calender = calender;
        this.schedules = schedules;
    }

    public void add(String name) {
        schedules.add(name);
    }

}
