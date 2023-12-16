package oncall.util;

public class ExceptionEnum {

    ;

    private static final String ERROR = "[ERROR] ";
    private String message;

    ExceptionEnum(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }

}
