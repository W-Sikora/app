package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import org.springframework.util.Assert;


public record PlannedExpenditureDeleteCommand(Long budgetId, Long plannedExpenditureId) {

    public PlannedExpenditureDeleteCommand {

        Assert.notNull(budgetId, "budgetId must not be null");
        Assert.notNull(plannedExpenditureId, "plannedExpenditureId must not be null");

    }

}
