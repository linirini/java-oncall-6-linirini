package oncall.domain;

import static java.util.stream.Collectors.toList;
import static oncall.util.Constants.MAXIMUM_NICK_NAME_COUNT;
import static oncall.util.Constants.MAXIMUM_NICK_NAME_LENGTH;
import static oncall.util.Constants.MINIMUM_NICK_NAME_COUNT;
import static oncall.util.Constants.MINIMUM_NICK_NAME_LENGTH;
import static oncall.util.ExceptionEnum.INVALID_NICK_NAME_COUNT;
import static oncall.util.ExceptionEnum.INVALID_NICK_NAME_LENGTH;

import java.util.List;

public class WorkingOrders {

    private final List<String> workingOrders;

    public WorkingOrders(List<String> workingOrders) {
        validate(workingOrders);
        this.workingOrders = workingOrders;
    }

    private void validate(List<String> workingOrders) {
        throwIfInvalidNicknameCount(workingOrders);
        throwIfInvalidNickname(workingOrders);
    }

    private void throwIfInvalidNicknameCount(List<String> workingOrders) {
        if(workingOrders.size()<MINIMUM_NICK_NAME_COUNT||workingOrders.size()>MAXIMUM_NICK_NAME_COUNT){
            throw new IllegalArgumentException(INVALID_NICK_NAME_COUNT.getMessage());
        }
    }

    private void throwIfInvalidNickname(List<String> workingOrders) {
        if(workingOrders.stream().anyMatch(nickName -> nickName.length() < MINIMUM_NICK_NAME_LENGTH
                || nickName.length() > MAXIMUM_NICK_NAME_LENGTH)){
            throw new IllegalArgumentException(INVALID_NICK_NAME_LENGTH.getMessage());
        }
    }

}
