package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

import java.math.BigDecimal;


public interface ExpenditureAttributes {

    Long getExpenditureId();

    Long getCashFlowId();

    String getTitle();

    Long getCategoryId();

    Integer getPriority();

    String getDate();

    Integer getCurrency();

    BigDecimal getValue();

    String getPayee();

    boolean isRepeatInNextPeriod();

}
