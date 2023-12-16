package oncall.service;

import static oncall.util.Constants.START_DATE;

import oncall.domain.Calender;
import oncall.domain.WorkSchedule;
import oncall.domain.WorkingOrders;
import oncall.util.calender.Holiday;

public class AllocationService {

    public WorkSchedule allocate(Calender calender, WorkingOrders weekWorkers,
            WorkingOrders weekendWorkers) {
        WorkSchedule workSchedule = new WorkSchedule(calender);
        for (int date = START_DATE; date <= calender.getLastDateOfMonth(); date++) {
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
        if (calender.isWeekend(date)|| Holiday.isHoliday(calender.getMonth(),date)) {
            return weekendWorkers.getWorker();
        }
        return weekWorkers.getWorker();
    }

}
