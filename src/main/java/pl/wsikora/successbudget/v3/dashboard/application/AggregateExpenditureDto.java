package pl.wsikora.successbudget.v3.dashboard.application;

import lombok.Value;

import java.math.BigDecimal;


@Value
public class AggregateExpenditureDto {

    BigDecimal planned;
    BigDecimal current;
    Integer currencyId;

}
