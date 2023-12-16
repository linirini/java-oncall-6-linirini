package oncall.service;

import oncall.domain.Calender;
import oncall.domain.WorkSchedule;
import oncall.domain.WorkingOrders;

public class AllocationService {

    public WorkSchedule allocate(Calender calender, WorkingOrders weekWorkers,
            WorkingOrders weekendWorkers) {
        WorkSchedule workSchedule = new WorkSchedule(calender);
        for (int date = 1; date < calender.getLastDateOfMonth(); date++) {
            String workerName = getWorkerName(calender, weekWorkers, weekendWorkers, date);
            workSchedule.add(workerName);
            if (workedYesterday(date, workerName, workSchedule)) {
                String tomorrowWorkerName = getWorkerName(calender, weekWorkers, weekendWorkers, date);
                workSchedule.change(tomorrowWorkerName, date);
            }
        }
        return workSchedule;
    }

    private boolean workedYesterday(int date, String workerName, WorkSchedule workSchedule) {
        return workSchedule.getWorker(date - 1).equals(workSchedule.getWorker(date));
    }

    private String getWorkerName(Calender calender, WorkingOrders weekWorkers,
            WorkingOrders weekendWorkers, int date) {
        if (calender.isWeekend(date)) {
            return weekendWorkers.getWorker();
        }
        return weekWorkers.getWorker();
    }

}
