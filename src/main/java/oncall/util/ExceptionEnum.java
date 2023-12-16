package oncall.util;

public enum ExceptionEnum {

    INVALID_NICK_NAME_LENGTH("닉네임은 최소 1자, 최대 5자 입력 가능합니다.");

    private static final String ERROR = "[ERROR] ";
    private String message;

    ExceptionEnum(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }

}
