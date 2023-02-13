package pl.wsikora.successbudget.v3.budget.application.budget;

import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.time.YearMonth;


public record BudgetFilter(Pageable pageable,
                           YearMonth period,
                           @Nullable Long categoryId) {

    public BudgetFilter {

        Assert.notNull(pageable, "pageable must not be null");
        Assert.notNull(period, "period must not be null");
    }

}
