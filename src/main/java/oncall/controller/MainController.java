package oncall.controller;

import static oncall.util.Constants.SEPARATOR;

import java.util.List;
import oncall.domain.Calender;
import oncall.util.Validator;
import oncall.util.calender.Day;
import oncall.util.calender.Month;
import oncall.view.InputView;
import oncall.view.OutputView;

public class MainController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void run() {
        Calender calender = getCalenderUntilNoError();
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

    private void validateFormat(String input) {
        Validator.checkEmptyValue(input);
        Validator.checkFrontBlank(input);
    }


}

}
