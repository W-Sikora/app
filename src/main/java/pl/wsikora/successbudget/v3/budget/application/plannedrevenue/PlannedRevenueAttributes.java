package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import java.math.BigDecimal;


public interface PlannedRevenueAttributes {

    Long getPlannedRevenueId();

    Long getBudgetId();

    Long getCategoryId();

    Integer getCurrencyId();

    BigDecimal getValue();

    Integer getScheduleId();

}
