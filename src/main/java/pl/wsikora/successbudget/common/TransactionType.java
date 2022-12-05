package pl.wsikora.successbudget.common;

import java.util.Arrays;
import java.util.Optional;


public enum TransactionType {

    INCOME(1),
    EXPENDITURE(2);

    private final long id;

    TransactionType(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public static Optional<TransactionType> findById(Long transactionTypeId) {

        return Arrays.stream(TransactionType.values())
                .filter(transactionType -> transactionType.getId() == transactionTypeId)
                .findFirst();
    }
}
