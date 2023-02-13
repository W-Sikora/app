package pl.wsikora.successbudget.v3.common.dashboard.total.revenue;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.money.Money;


@Value
public class TotalRevenue {

    Money planned;
    Money current;

}
