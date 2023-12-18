package oncall.domain;

import static oncall.util.Constants.WEEKEND_ORDER;
import static oncall.util.Constants.WEEK_ORDER;
import static oncall.util.ExceptionEnum.SAME_ORDERS;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    List<WorkingOrders> orders;

    public Orders(WorkingOrders weekWorkingOrders, WorkingOrders weekendWorkingOrders) {
        List<WorkingOrders> workingOrders = new ArrayList<>();
        workingOrders.add(WEEK_ORDER,weekWorkingOrders);
        workingOrders.add(WEEKEND_ORDER,weekendWorkingOrders);
        validate(workingOrders);
        this.orders = workingOrders;
    }

    private void validate(List<WorkingOrders> orders) {
        throwIfSameOrders(orders);
    }

    private void throwIfSameOrders(List<WorkingOrders> orders) {
        if(orders.get(WEEK_ORDER).getWorkingOrders().equals(orders.get(WEEKEND_ORDER).getWorkingOrders())){
            throw new IllegalArgumentException(SAME_ORDERS.getMessage());
        }
    }

    public WorkingOrders getWeekOrders(){
        return orders.get(WEEK_ORDER);
    }

    public WorkingOrders getWeekendOrders(){
        return orders.get(WEEKEND_ORDER);
    }

}
