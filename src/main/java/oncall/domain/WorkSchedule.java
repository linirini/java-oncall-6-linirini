package oncall.domain;

import static oncall.util.Constants.NONE;

import java.util.ArrayList;
import java.util.List;

public class WorkSchedule {

    private final Calender calender;
    private final List<String> schedules;

    public WorkSchedule(Calender calender) {
        this.calender = calender;
        this.schedules = getEmptySchedule();
    }

    private List<String> getEmptySchedule() {
        List<String> schedule = new ArrayList<>();
        schedule.add(NONE);
        return schedule;
    }

    public void add(String name) {
        schedules.add(name);
    }

    public String getWorker(int date) {
        return schedules.get(date);
    }


    public void change(String workerName, int date) {
        schedules.remove(date);
        schedules.add(workerName);
    }

    public Calender getCalender() {
        return calender;
    }

}
