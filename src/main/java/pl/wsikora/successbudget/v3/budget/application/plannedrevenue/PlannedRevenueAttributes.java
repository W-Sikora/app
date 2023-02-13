package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import java.math.BigDecimal;
import java.time.YearMonth;


public interface PlannedRevenueAttributes {

    Long getPlannedRevenueId();

    YearMonth getPeriod();

    Long getCategoryId();

    Integer getCurrency();

    BigDecimal getValue();

    boolean isRepeatInNextPeriod();

}
