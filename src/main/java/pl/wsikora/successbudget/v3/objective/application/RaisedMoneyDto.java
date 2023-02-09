package pl.wsikora.successbudget.v3.objective.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.money.MoneyDto;


@Value
public class RaisedMoneyDto {

    Long raisedMoneyId;
    MoneyDto moneyDto;
    String date;

}
