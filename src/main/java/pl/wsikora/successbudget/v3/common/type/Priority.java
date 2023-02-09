package pl.wsikora.successbudget.v3.common.type;

import pl.wsikora.successbudget.v3.common.exception.NotFoundException;

import java.util.Arrays;
import java.util.List;


public enum Priority {

    UNNECESSARY,
    LOW,
    NORMAL,
    HIGH,
    CRITICAL;

    public static Priority getByPriorityId(int priorityId) {

        Priority[] values = Priority.values();

        if (priorityId < 0 || priorityId > values.length) {

            throw new NotFoundException("priority", priorityId);
        }

        return values[priorityId];
    }

    public static List<Integer> getOrdinals() {

        return Arrays.stream(Priority.values())
            .map(Priority::ordinal)
            .toList();
    }

}
