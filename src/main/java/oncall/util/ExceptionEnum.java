package oncall.util;

public enum ExceptionEnum {

    INVALID_NICK_NAME_LENGTH("닉네임은 최소 1자, 최대 5자 입력 가능합니다."),
    INVALID_NICK_NAME_COUNT("최소 4명, 최대 35명의 근무자를 입력해주세요."),
    DUPLICATED_NICK_NAME("중복된 닉네임을 입력할 수 없습니다."),
    INVALID_MONTH("존재하지 않는 월 정보입니다.");

    private static final String ERROR = "[ERROR] ";
    private String message;

    ExceptionEnum(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }

}
