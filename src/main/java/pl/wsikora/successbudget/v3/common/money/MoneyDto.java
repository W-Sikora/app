package pl.wsikora.successbudget.v3.common.money;

import lombok.Value;

import java.math.BigDecimal;


@Value
public class MoneyDto {

    Integer currencyId;
    BigDecimal value;
    String formattedValue;

}
