package pl.wsikora.successbudget.v3.budget.application.budget;

import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;


public record BudgetFilter(Pageable pageable,
                           Long budgetId,
                           @Nullable Long categoryId) {

    public BudgetFilter {

        Assert.notNull(pageable, "pageable must not be null");
        Assert.notNull(budgetId, "cashFlowId must not be null");
    }

}
