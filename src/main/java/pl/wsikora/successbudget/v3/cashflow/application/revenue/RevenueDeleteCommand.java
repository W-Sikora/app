package pl.wsikora.successbudget.v3.cashflow.application.revenue;

import org.springframework.util.Assert;


public record RevenueDeleteCommand(Long cashFlowId, Long revenueId) {

    public RevenueDeleteCommand {

        Assert.notNull(cashFlowId, "cashFlowId must not be null");
        Assert.notNull(revenueId, "revenueId must not be null");
    }

}
