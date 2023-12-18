package oncall.service;

import static oncall.util.Constants.START_DATE;

import oncall.domain.Calender;
import oncall.domain.Orders;
import oncall.domain.WorkSchedule;
import oncall.util.calender.Holiday;

public class AllocationService {

    public WorkSchedule allocate(Calender calender, Orders orders) {
        WorkSchedule workSchedule = new WorkSchedule(calender);
        for (int date = START_DATE; date <= calender.getLastDateOfMonth(); date++) {
            String workerName = getWorkerName(calender, orders, date);
            if (workedYesterday(date, workerName, workSchedule)) {
                String nextTurnWorkerName = getWorkerNameWhileNotSame(calender,orders,date,workerName);
                workSchedule.add(nextTurnWorkerName);
            }
            workSchedule.add(workerName);
        }
        return workSchedule;
    }

    private boolean workedYesterday(int date, String workerName, WorkSchedule workSchedule) {
        return workSchedule.getWorker(date - 1).equals(workerName);
    }

    private String getWorkerNameWhileNotSame(Calender calender, Orders orders, int date, String workerName) {
        while(true){
            String nextTurnWorkerName = getWorkerName(calender,orders,date);
            if(!nextTurnWorkerName.equals(workerName)){
                return nextTurnWorkerName;
            }
        }
    }

    private String getWorkerName(Calender calender, Orders orders, int date) {
        if (calender.isWeekend(date) || Holiday.isHoliday(calender.getMonth(), date)) {
            return orders.getWeekendOrders().pullOutWorker();
        }
        return orders.getWeekOrders().pullOutWorker();
    }

}
