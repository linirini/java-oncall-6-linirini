package oncall.domain;

import static oncall.util.Constants.WEEKEND_ORDER;
import static oncall.util.Constants.WEEK_ORDER;

import java.util.List;

public class Orders {

    List<WorkingOrders> orders;

    public Orders(List<WorkingOrders> orders) {
        this.orders = orders;
    }

    public WorkingOrders getWeekOrders(){
        return orders.get(WEEK_ORDER);
    }

    public WorkingOrders getWeekendOrders(){
        return orders.get(WEEKEND_ORDER);
    }

}
