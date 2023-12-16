package oncall.view;

import static oncall.util.Constants.BLANK;
import static oncall.util.Constants.START_DATE;

import oncall.domain.Calender;
import oncall.domain.WorkSchedule;
import oncall.util.calender.Holiday;

public class OutputView {

    private static final String MONTH = "월 ";
    private static final String DATE = "일";
    private static final String HOLIDAY = "(휴일)";

    public void printEmergencyWorkSchedule(WorkSchedule workSchedule) {
        Calender calender = workSchedule.getCalender();
        for (int date = START_DATE; date <= calender.getLastDateOfMonth(); date++) {
            StringBuilder output = getScheduleOutput(workSchedule, calender, date);
            System.out.println(output);
        }
    }

    private StringBuilder getScheduleOutput(WorkSchedule workSchedule, Calender calender,
            int date) {
        StringBuilder output = new StringBuilder();
        output.append(calender.getMonth() + MONTH);
        output.append(date + DATE);
        if (!calender.isWeekend(date) && Holiday.isHoliday(calender.getMonth(), date)) {
            output.append(HOLIDAY);
        }
        output.append(BLANK);
        output.append(workSchedule.getWorker(date));
        return output;
    }

}
