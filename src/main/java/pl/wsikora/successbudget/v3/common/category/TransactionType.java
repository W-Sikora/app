package pl.wsikora.successbudget.v3.common.category;

import java.util.Arrays;
import java.util.List;


public enum TransactionType {

    REVENUE,
    EXPENDITURE;

    public static List<Integer> getOrdinals() {

        return Arrays.stream(TransactionType.values())
            .map(TransactionType::ordinal)
            .toList();
    }

}
