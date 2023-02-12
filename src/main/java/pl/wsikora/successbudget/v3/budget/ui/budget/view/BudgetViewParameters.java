package pl.wsikora.successbudget.v3.budget.ui.budget.view;

import org.springframework.util.Assert;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_PAGE;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_SIZE;


record BudgetViewParameters(Long budgetId,
                            Integer plannedExpenditurePage,
                            Integer plannedExpenditureSize,
                            Integer plannedRevenuePage,
                            Integer plannedRevenueSize) {

    BudgetViewParameters(Long budgetId,
                         Integer plannedExpenditurePage,
                         Integer plannedExpenditureSize,
                         Integer plannedRevenuePage,
                         Integer plannedRevenueSize) {

        Assert.notNull(budgetId, "budgetId must not be null");

        this.budgetId = budgetId;

        this.plannedExpenditurePage = isNull(plannedExpenditurePage) ?
            DEFAULT_PAGINATION_PAGE : plannedExpenditurePage;

        this.plannedExpenditureSize = isNull(plannedExpenditureSize) ?
            DEFAULT_PAGINATION_SIZE : plannedExpenditureSize;

        this.plannedRevenuePage = isNull(plannedRevenuePage) ?
            DEFAULT_PAGINATION_PAGE : plannedRevenuePage;

        this.plannedRevenueSize = isNull(plannedRevenueSize) ?
            DEFAULT_PAGINATION_SIZE : plannedRevenueSize;
    }

}
