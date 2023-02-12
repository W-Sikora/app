package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

import org.springframework.util.Assert;


public record ExpenditureDeleteCommand(Long cashFlowId, Long expenditureId) {

    public ExpenditureDeleteCommand {

        Assert.notNull(cashFlowId, "cashFlowId must not be null");
        Assert.notNull(expenditureId, "revenueId must not be null");
    }

}
