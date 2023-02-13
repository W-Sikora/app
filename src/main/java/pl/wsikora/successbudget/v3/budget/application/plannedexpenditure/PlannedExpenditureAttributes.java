package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import java.math.BigDecimal;
import java.time.YearMonth;


public interface PlannedExpenditureAttributes {

    Long getPlannedExpenditureId();

    YearMonth getPeriod();

    Long getCategoryId();

    Integer getPriority();

    Integer getCurrency();

    BigDecimal getValue();

    boolean isRepeatInNextPeriod();

}
