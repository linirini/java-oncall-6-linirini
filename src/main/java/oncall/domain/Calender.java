package oncall.domain;

import oncall.util.Month;

public class Calender {

    private final Month month;
    private final int startDate;

    public Calender(Month month, int startDate) {
        this.month = month;
        this.startDate = startDate;
    }

}
