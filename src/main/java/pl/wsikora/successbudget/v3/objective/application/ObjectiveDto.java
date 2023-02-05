package pl.wsikora.successbudget.v3.objective.application;

import lombok.Value;

import java.math.BigDecimal;


@Value
public class ObjectiveDto {

    Long objectiveId;
    String title;
    String description;
    Long necessaryMoneyCurrencyId;
    BigDecimal necessaryMoney;
    Long raisedMoneyCurrencyId;
    BigDecimal raisedMoney;
    boolean realized;

}
