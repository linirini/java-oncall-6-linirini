package oncall.domain;

import java.util.HashMap;
import java.util.List;
import oncall.util.Calender;

public class WorkSchedule {

    private final HashMap<Calender, List<String>> allocationResult;

    public WorkSchedule(HashMap<Calender, List<String>> allocationResult) {
        this.allocationResult = allocationResult;
    }

}
