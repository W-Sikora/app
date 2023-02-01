package pl.wsikora.successbudget.v3.common.type;

import java.util.Arrays;
import java.util.List;


public enum Priority {

    UNNECESSARY,
    LOW,
    NORMAL,
    HIGH,
    CRITICAL;

    public static List<Integer> getOrdinals() {

        return Arrays.stream(Priority.values())
            .map(Priority::ordinal)
            .toList();
    }
}
