package pl.wsikora.successbudget.v3.common.type;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Schedule {

    DAILY("0 0 0 1/1 * ? *"),
    ONCE_A_MONTH("0 0 12 1 1/1 ? *");

    private final String cronExpressions;

    Schedule(String cronExpressions) {

        this.cronExpressions = cronExpressions;
    }

    public static List<Integer> getOrdinals() {

        return Arrays.stream(Schedule.values())
            .map(Schedule::ordinal)
            .toList();
    }
}
