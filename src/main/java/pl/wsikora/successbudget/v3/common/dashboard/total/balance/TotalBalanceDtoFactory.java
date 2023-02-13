package pl.wsikora.successbudget.v3.common.dashboard.total.balance;

import pl.wsikora.successbudget.v3.common.dashboard.total.expenditure.TotalExpenditure;
import pl.wsikora.successbudget.v3.common.dashboard.total.objective.TotalObjective;
import pl.wsikora.successbudget.v3.common.dashboard.total.revenue.TotalRevenue;
import pl.wsikora.successbudget.v3.common.type.money.Money;


public class TotalBalanceDtoFactory {

    private TotalBalanceDtoFactory() {}

    public TotalBalanceDto create(TotalExpenditure totalExpenditure,
                                  TotalRevenue totalRevenue,
                                  TotalObjective totalObjective) {

        Money totalBalance = totalRevenue.getCurrent()
            .subtract(totalExpenditure.getCurrent())
            .subtract(totalObjective.getValue());

        return new TotalBalanceDto(totalBalance.getFormattedValue());
    }

}
