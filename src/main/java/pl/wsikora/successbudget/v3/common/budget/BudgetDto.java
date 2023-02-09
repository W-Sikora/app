package pl.wsikora.successbudget.v3.common.budget;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.money.MoneyDto;


@Value
public class BudgetDto {

    Long budgetId;
    String yearMonth;
    MoneyDto totalPlannedExpenditures;
    MoneyDto totalPlannedRevenues;

}
