package pl.wsikora.successbudget.v3.objective.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.application.MoneyDto;

import java.util.Set;


@Value
public class ObjectiveDto {

    Long objectiveId;
    String title;
    String description;
    MoneyDto necessaryMoneyDto;
    Set<MoneyDto> raisedMoneyDto;
    boolean realized;

}
