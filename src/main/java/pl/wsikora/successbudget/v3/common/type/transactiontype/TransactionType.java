package pl.wsikora.successbudget.v3.common.type.transactiontype;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;


public enum TransactionType {

    EXPENDITURE,
    REVENUE;

    public static TransactionType of(Integer ordinal) {

        Assert.isTrue(hasValidOrdinalRange(ordinal), "TransactionType ordinal must be of valid value");

        return TransactionType.values()[ordinal];
    }

    public static List<Integer> getOrdinals() {

        return Arrays.stream(TransactionType.values())
            .map(TransactionType::ordinal)
            .toList();
    }

    public static boolean hasValidOrdinalRange(Integer ordinal) {

        Assert.notNull(ordinal, "TransactionType ordinal must not be null");

        return ordinal > 0 || ordinal < TransactionType.values().length;
    }

}
