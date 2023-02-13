package pl.wsikora.successbudget.v3.common.type.money;

import lombok.Value;


@Value
public class MoneyDto {

    Integer currency;
    String sign;
    String formattedValue;
    boolean negative;

}
