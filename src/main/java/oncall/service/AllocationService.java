package oncall.service;

import oncall.domain.Calender;
import oncall.domain.WorkSchedule;
import oncall.domain.WorkingOrders;

public class AllocationService {

    public WorkSchedule allocate(Calender calender, WorkingOrders weekWorkers,
            WorkingOrders weekendWorkers) {
        WorkSchedule workSchedule = new WorkSchedule(calender);
        int weekWorkerSequence = 0;
        int weekendWorkerSequence = 0;
        for (int date = 1; date < calender.getLastDateOfMonth(); date++) {
            String workerName = getWorkerName(calender, weekWorkers, weekendWorkers,
                    weekWorkerSequence,
                    weekendWorkerSequence, date);
            workSchedule.add(workerName);
        }
        return workSchedule;
    }

    private String getWorkerName(Calender calender, WorkingOrders weekWorkers,
            WorkingOrders weekendWorkers, int weekWorkerSequence, int weekendWorkerSequence,
            int date) {
        if (calender.isWeekend(date)) {
            weekendWorkerSequence++;
            return weekendWorkers.getWorker(weekendWorkerSequence);
        }
        weekWorkerSequence++;
        return weekWorkers.getWorker(weekWorkerSequence);
    }

}
