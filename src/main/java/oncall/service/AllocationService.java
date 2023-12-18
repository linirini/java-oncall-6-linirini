package oncall.service;

import static oncall.util.Constants.START_DATE;

import oncall.domain.Calender;
import oncall.domain.Orders;
import oncall.domain.WorkSchedule;
import oncall.domain.WorkingOrders;
import oncall.util.calender.Holiday;

public class AllocationService {

    public WorkSchedule allocate(Calender calender, Orders orders) {
        WorkSchedule workSchedule = new WorkSchedule(calender);
        WorkingOrders weekWorkers = orders.getWeekOrders();
        WorkingOrders weekendWorkers = orders.getWeekendOrders();
        for (int date = START_DATE; date <= calender.getLastDateOfMonth(); date++) {
            String workerName = getWorkerName(calender, weekWorkers, weekendWorkers, date);
            if (workedYesterday(date, workerName, workSchedule)) {
                String nextTurnWorkerName = getWorkerName(calender, weekWorkers, weekendWorkers,
                        date);
                workSchedule.add(nextTurnWorkerName);
            }
            workSchedule.add(workerName);
        }
        return workSchedule;
    }

    private boolean workedYesterday(int date, String workerName, WorkSchedule workSchedule) {
        return workSchedule.getWorker(date - 1).equals(workerName);
    }

    private String getWorkerName(Calender calender, WorkingOrders weekWorkers,
            WorkingOrders weekendWorkers, int date) {
        if (calender.isWeekend(date) || Holiday.isHoliday(calender.getMonth(), date)) {
            return weekendWorkers.pullOutWorker();
        }
        return weekWorkers.pullOutWorker();
    }

}
