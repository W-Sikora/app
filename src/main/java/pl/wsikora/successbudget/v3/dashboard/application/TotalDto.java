package pl.wsikora.successbudget.v3.dashboard.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;


@Value
public class TotalDto {

    MoneyDto totalPlannedExpenditure;
    MoneyDto totalCurrentExpenditure;
    MoneyDto totalPlannedRevenue;
    MoneyDto totalCurrentRevenue;
    MoneyDto plannedBalance;
    MoneyDto currentBalance;

}
