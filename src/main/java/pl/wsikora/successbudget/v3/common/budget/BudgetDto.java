package pl.wsikora.successbudget.v3.common.budget;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;


@Value
public class BudgetDto {

    String period;
    MoneyDto totalPlannedExpenditures;
    MoneyDto totalPlannedRevenues;
    MoneyDto balance;

}
