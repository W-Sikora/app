package pl.wsikora.successbudget.v3.objective.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;


@Value
public class RaisedMoneyDto {

    Long raisedMoneyId;
    MoneyDto moneyDto;
    String date;

}
