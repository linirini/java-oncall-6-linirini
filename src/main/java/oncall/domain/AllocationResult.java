package oncall.domain;

import java.util.HashMap;
import java.util.List;
import oncall.util.Calender;

public class AllocationResult {

    private final HashMap<Calender, List<String>> allocationResult;

    public AllocationResult(HashMap<Calender, List<String>> allocationResult) {
        this.allocationResult = allocationResult;
    }

}
