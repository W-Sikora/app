package pl.wsikora.successbudget.v3.common.type;

public enum TransactionType {

    REVENUE,
    EXPENDITURE;

    public boolean isRevenue() {

        return this == REVENUE;
    }

    public boolean isExpenditure() {

        return this == EXPENDITURE;
    }
}
