package oncall.util;

import java.util.Arrays;

public enum Day {

    MONDAY("월",1),

    TUESDAY("화",2),

    WEDNESDAY("수",3),

    THURSDAY("목",4),

    FRIDAY("금",5),

    SATURDAY("토",6),

    SUNDAY("일",7);
    
    private final String name;
    private final int sequence;

    Day(String name, int sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public static Day getDayByName(String name){
        Arrays.stream(values()).filter(day -> day.name.equals(name)).findFirst().orElseThrow(IllegalArgumentException(INVALID_DAY.getMessage()));
    }

}
