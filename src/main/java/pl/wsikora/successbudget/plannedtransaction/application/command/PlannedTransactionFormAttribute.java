package pl.wsikora.successbudget.plannedtransaction.application.command;

import java.math.BigDecimal;
import java.time.YearMonth;


public interface PlannedTransactionFormAttribute {

    Long getId();

    Long getBudgetId();

    String getName();

    Long getTransactionTypeId();

    Long getParentCategoryId();

    Long getCategoryId();

    BigDecimal getValue();

    Long getCurrencyId();

    Long getCreatedByUserId();

    String getCycleValue();

    YearMonth getAccountingPeriod();
}
