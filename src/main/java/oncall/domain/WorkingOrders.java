package oncall.domain;

import static java.util.stream.Collectors.toList;
import static oncall.util.Constants.MAXIMUM_NICK_NAME_LENGTH;
import static oncall.util.Constants.MINIMUM_NICK_NAME_LENGTH;
import static oncall.util.ExceptionEnum.INVALID_NICK_NAME_LENGTH;

import java.util.List;

public class WorkingOrders {

    private final List<String> workingOrders;

    public WorkingOrders(List<String> workingOrders) {
        validate(workingOrders);
        this.workingOrders = workingOrders;
    }

    private void validate(List<String> workingOrders) {
        throwIfInvalidNickname(workingOrders);
    }

    private void throwIfInvalidNickname(List<String> workingOrders) {
        if(workingOrders.stream().anyMatch(nickName -> nickName.length() < MINIMUM_NICK_NAME_LENGTH
                || nickName.length() > MAXIMUM_NICK_NAME_LENGTH)){
            throw new IllegalArgumentException(INVALID_NICK_NAME_LENGTH.getMessage());
        }
    }

}
