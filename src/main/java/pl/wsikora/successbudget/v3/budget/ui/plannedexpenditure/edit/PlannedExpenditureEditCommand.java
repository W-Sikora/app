package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import org.springframework.util.Assert;


record PlannedExpenditureEditCommand(Long budgetId, Long plannedExpenditureId) {

    PlannedExpenditureEditCommand {

        Assert.notNull(budgetId, "budgetId must not be null");
    }

}
