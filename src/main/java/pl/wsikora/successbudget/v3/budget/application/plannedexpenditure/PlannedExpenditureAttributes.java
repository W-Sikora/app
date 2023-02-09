package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import java.math.BigDecimal;


public interface PlannedExpenditureAttributes {

    Long getPlannedExpenditureId();

    Long getBudgetId();

    Long getCategoryId();

    Integer getPriorityId();

    Integer getCurrencyId();

    BigDecimal getValue();

    boolean isRepeatInNextPeriod();

}
