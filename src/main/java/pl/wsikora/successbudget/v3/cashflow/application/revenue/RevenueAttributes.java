package pl.wsikora.successbudget.v3.cashflow.application.revenue;

import java.math.BigDecimal;


public interface RevenueAttributes {

    Long getRevenueId();

    Long getCashFlowId();

    String getTitle();

    Long getCategoryId();

    String getDate();

    Integer getCurrency();

    BigDecimal getValue();

    String getPayer();

    boolean isRepeatInNextPeriod();

}
