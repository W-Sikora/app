package pl.wsikora.successbudget.v3.cashflow.application.cashflow;

import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.YearMonth;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


public record CashFlowFilter(Pageable pageable,
                             YearMonth period,
                             @Nullable String expenditureKeyword,
                             @Nullable String revenueKeyword,
                             @Nullable Long categoryId,
                             @Nullable LocalDate fromDate,
                             @Nullable LocalDate toDate) {

    public CashFlowFilter {

        Assert.notNull(pageable, "pageable must not be null");
        Assert.notNull(period, "period must not be null");
        Assert.isTrue(areDatesValid(fromDate, toDate), "dates must be valid");

    }

    private boolean areDatesValid(LocalDate fromDate, LocalDate toDate) {

        if (isNull(fromDate) && nonNull(toDate)) {

            return false;
        }

        return isNull(fromDate) || nonNull(toDate);
    }

}
