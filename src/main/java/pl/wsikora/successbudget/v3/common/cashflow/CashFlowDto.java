package pl.wsikora.successbudget.v3.common.cashflow;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;


@Value
public class CashFlowDto {

    String period;
    MoneyDto totalExpenditures;
    MoneyDto totalRevenues;
    MoneyDto balance;

}
