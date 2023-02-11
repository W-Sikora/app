package pl.wsikora.successbudget.v3.common.type.priority;

import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionType;

import java.util.Arrays;
import java.util.List;


public enum Priority {

    UNNECESSARY,
    LOW,
    NORMAL,
    HIGH,
    CRITICAL;

    public static Priority of(Integer ordinal) {

        Assert.isTrue(hasValidOrdinalRange(ordinal), "Priority ordinal must be of valid ordinal");

        return Priority.values()[ordinal];
    }

    public static List<Integer> getOrdinals() {

        return Arrays.stream(Priority.values())
            .map(Priority::ordinal)
            .toList();
    }

    public static boolean hasValidOrdinalRange(Integer ordinal) {

        Assert.notNull(ordinal, "Priority ordinal must not be null");

        return ordinal > 0 || ordinal < TransactionType.values().length;
    }

}
