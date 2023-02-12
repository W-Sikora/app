package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import org.springframework.util.Assert;


public record PlannedRevenueDeleteCommand(Long budgetId, Long plannedRevenueId) {

    public PlannedRevenueDeleteCommand {

        Assert.notNull(budgetId, "budgetId must not be null");
        Assert.notNull(plannedRevenueId, "plannedRevenueId must not be null");

    }

}
