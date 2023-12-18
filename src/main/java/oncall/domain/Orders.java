package oncall.domain;

import static oncall.util.Constants.WEEKEND_ORDER;
import static oncall.util.Constants.WEEK_ORDER;
import static oncall.util.ExceptionEnum.SAME_ORDERS;

import java.util.List;

public class Orders {

    List<WorkingOrders> orders;

    public Orders(List<WorkingOrders> orders) {
        validate(orders);
        this.orders = orders;
    }

    private void validate(List<WorkingOrders> orders) {
        throwIfSameOrders(orders);
    }

    private void throwIfSameOrders(List<WorkingOrders> orders) {
        if(getWeekOrders().equals(getWeekendOrders())){
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
