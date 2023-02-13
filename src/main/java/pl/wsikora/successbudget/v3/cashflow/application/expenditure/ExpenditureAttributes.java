package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

import java.math.BigDecimal;
import java.time.YearMonth;


public interface ExpenditureAttributes {

    Long getExpenditureId();

    YearMonth getPeriod();

    String getTitle();

    Long getCategoryId();

    Integer getPriority();

    String getDate();

    Integer getCurrency();

    BigDecimal getValue();

    String getPayee();

    boolean isRepeatInNextPeriod();

}
