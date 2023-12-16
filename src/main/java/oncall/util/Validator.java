package oncall.util;

import static oncall.util.Constants.BLANK;
import static oncall.util.Constants.NUM_OF_ITEM;
import static oncall.util.ExceptionEnum.EMPTY_INPUT;
import static oncall.util.ExceptionEnum.FRONT_BLANK;
import static oncall.util.ExceptionEnum.LESS_INFO;

public class Validator {

    public static void checkEmptyValue(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    public static void checkFrontBlank(String input) {
        if (input.charAt(0) == BLANK) {
            throw new IllegalArgumentException(FRONT_BLANK.getMessage());
        }
    }

    public static void checkInfoCount(String[] input) {
        if (input.length != NUM_OF_ITEM) {
            throw new IllegalArgumentException(LESS_INFO.getMessage());
        }
    }

}
