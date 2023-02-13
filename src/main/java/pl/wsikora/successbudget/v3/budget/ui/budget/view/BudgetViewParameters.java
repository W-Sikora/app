package pl.wsikora.successbudget.v3.budget.ui.budget.view;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.time.YearMonth;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_PAGE;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_SIZE;


record BudgetViewParameters(YearMonth period,
                            @Nullable Integer plannedExpenditurePage,
                            @Nullable Integer plannedExpenditureSize,
                            @Nullable Integer plannedRevenuePage,
                            @Nullable Integer plannedRevenueSize,
                            @Nullable Long plannedExpenditureCategoryId,
                            @Nullable Long plannedRevenueCategoryId) {

    BudgetViewParameters(YearMonth period,
                         @Nullable Integer plannedExpenditurePage,
                         @Nullable Integer plannedExpenditureSize,
                         @Nullable Integer plannedRevenuePage,
                         @Nullable Integer plannedRevenueSize,
                         @Nullable Long plannedExpenditureCategoryId,
                         @Nullable Long plannedRevenueCategoryId) {

        Assert.notNull(period, "period must not be null");

        this.period = period;

        this.plannedExpenditurePage = isNull(plannedExpenditurePage) ?
            DEFAULT_PAGINATION_PAGE : plannedExpenditurePage;

        this.plannedExpenditureSize = isNull(plannedExpenditureSize) ?
            DEFAULT_PAGINATION_SIZE : plannedExpenditureSize;

        this.plannedRevenuePage = isNull(plannedRevenuePage) ?
            DEFAULT_PAGINATION_PAGE : plannedRevenuePage;

        this.plannedRevenueSize = isNull(plannedRevenueSize) ?
            DEFAULT_PAGINATION_SIZE : plannedRevenueSize;

        this.plannedExpenditureCategoryId = plannedExpenditureCategoryId;

        this.plannedRevenueCategoryId = plannedRevenueCategoryId;
    }

}
