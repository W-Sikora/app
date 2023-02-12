package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import org.springframework.util.Assert;


record PlannedRevenueEditCommand(Long budgetId, Long plannedRevenueId) {

    PlannedRevenueEditCommand {

        Assert.notNull(budgetId, "budgetId must not be null");
    }

}
