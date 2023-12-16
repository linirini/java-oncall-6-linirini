package oncall.controller;

import static oncall.util.Constants.SEPARATOR;
import static oncall.util.ExceptionEnum.SAME_ORDERS;

import java.util.List;
import oncall.domain.Calender;
import oncall.domain.WorkSchedule;
import oncall.domain.WorkingOrders;
import oncall.service.AllocationService;
import oncall.util.Validator;
import oncall.util.calender.Day;
import oncall.util.calender.Month;
import oncall.view.InputView;
import oncall.view.OutputView;

public class MainController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final AllocationService allocationService = new AllocationService();


    public void run() {
        Calender calender = getCalenderUntilNoError();
        WorkingOrders weekWorkingOrders = getWeekWorkingOrdersUntilNoError();
        WorkingOrders weekendWorkingOrders = getWeekendWorkingOrdersUntilNoError(weekWorkingOrders);
        WorkSchedule workSchedule = allocationService.allocate(calender, weekWorkingOrders,
                weekendWorkingOrders);
        outputView.printEmergencyWorkSchedule(workSchedule);
    }


    private Calender getCalenderUntilNoError() {
        while (true) {
            String input = inputView.inputMonthAndDay();
            try {
                validateFormat(input);
                return getCalender(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Calender getCalender(String input) {
        Validator.checkInfoCount(input.split(SEPARATOR));
        List<String> calenderInfo = List.of(input.split(SEPARATOR));
        return new Calender(Month.getMonth(calenderInfo.get(0)),
                Day.getDayByName(calenderInfo.get(1)));
    }

    private WorkingOrders getWeekWorkingOrdersUntilNoError() {
        while (true) {
            String input = inputView.inputWeekWorkingOrder();
            try {
                validateFormat(input);
                return new WorkingOrders(List.of(input.split(SEPARATOR)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WorkingOrders getWeekendWorkingOrdersUntilNoError(WorkingOrders weekWorkingOrders) {
        while (true) {
            String input = inputView.inputWeekendWorkingOrder();
            try {
                validateFormat(input);
                WorkingOrders weekendWorkingOrders = new WorkingOrders(
                        List.of(input.split(SEPARATOR)));
                throwIfSameAsWeekWorkingOrders(weekWorkingOrders, weekendWorkingOrders);
                return weekendWorkingOrders;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateFormat(String input) {
        Validator.checkEmptyValue(input);
        Validator.checkFrontBlank(input);
    }

    private void throwIfSameAsWeekWorkingOrders(WorkingOrders weekWorkingOrders,
            WorkingOrders weekendWorkingOrders) {
        if (weekWorkingOrders.getWorkingOrders().equals(weekendWorkingOrders.getWorkingOrders())) {
            throw new IllegalArgumentException(SAME_ORDERS.getMessage());
        }
    }


}

