package pl.wsikora.successbudget.v3.budget.application.budget;

import org.springframework.util.Assert;


public record BudgetRepeatCommand(Long fromBudgetId, Long toBudgetId) {

    public BudgetRepeatCommand {

        Assert.notNull(fromBudgetId, "fromBudgetId must not be null");
        Assert.notNull(toBudgetId, "toBudgetId must not be null");

    }

}
