package pl.wsikora.successbudget.v3.cashflow.application.cashflow;

import org.springframework.util.Assert;


public record CashFlowRepeatCommand(Long fromCashFlowId, Long toCashFlowId) {

    public CashFlowRepeatCommand {

        Assert.notNull(fromCashFlowId, "fromCashFlowId must not be null");
        Assert.notNull(toCashFlowId, "toCashFlowId must not be null");

    }

}
