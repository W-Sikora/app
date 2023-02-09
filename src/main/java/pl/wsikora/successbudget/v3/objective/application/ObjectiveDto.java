package pl.wsikora.successbudget.v3.objective.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.money.MoneyDto;


@Value
public class ObjectiveDto {

    Long objectiveId;
    String title;
    String description;
    MoneyDto necessaryMoneyDto;
    boolean realized;
    MoneyDto raisedMoneyDto;

}
