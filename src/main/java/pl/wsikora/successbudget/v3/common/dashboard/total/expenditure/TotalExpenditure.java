package pl.wsikora.successbudget.v3.common.dashboard.total.expenditure;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.money.Money;


@Value
public class TotalExpenditure {

    Money planned;
    Money current;

}
