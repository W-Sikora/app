package pl.wsikora.successbudget.v3.cashflow.ui.cashflow.view;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.time.YearMonth;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_PAGE;
import static pl.wsikora.successbudget.v3.common.util.Constants.DEFAULT_PAGINATION_SIZE;


record CashFlowViewParameters(YearMonth period,
                              @Nullable Integer expenditurePage,
                              @Nullable Integer expenditureSize,
                              @Nullable Integer revenuePage,
                              @Nullable Integer revenueSize,
                              @Nullable Long expenditureCategoryId,
                              @Nullable Long revenueCategoryId) {

    CashFlowViewParameters(YearMonth period,
                           @Nullable Integer expenditurePage,
                           @Nullable Integer expenditureSize,
                           @Nullable Integer revenuePage,
                           @Nullable Integer revenueSize,
                           @Nullable Long expenditureCategoryId,
                           @Nullable Long revenueCategoryId) {

        Assert.notNull(period, "period must not be null");

        this.period = period;

        this.expenditurePage = isNull(expenditurePage) ?
            DEFAULT_PAGINATION_PAGE : expenditurePage;

        this.expenditureSize = isNull(expenditureSize) ?
            DEFAULT_PAGINATION_SIZE : expenditureSize;

        this.revenuePage = isNull(revenuePage) ?
            DEFAULT_PAGINATION_PAGE : revenuePage;

        this.revenueSize = isNull(revenueSize) ?
            DEFAULT_PAGINATION_SIZE : revenueSize;

        this.expenditureCategoryId = expenditureCategoryId;

        this.revenueCategoryId = revenueCategoryId;
    }

}
