package pl.wsikora.successbudget.v3.dashboard.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.dashboard.aggregateexpenditure.AggregateExpendituresDto;
import pl.wsikora.successbudget.v3.common.dashboard.total.balance.TotalBalanceDto;
import pl.wsikora.successbudget.v3.common.dashboard.total.expenditure.TotalExpenditureDto;
import pl.wsikora.successbudget.v3.common.dashboard.total.objective.TotalObjectiveDto;
import pl.wsikora.successbudget.v3.common.dashboard.total.revenue.TotalRevenueDto;


@Value
public class DashboardDto {

    Long dashboardId;
    String period;
    Long previousDashboardId;
    Long nextDashboardId;
    Long budgetId;
    Long cashFlowId;
    TotalExpenditureDto totalExpenditureDto;
    TotalRevenueDto totalRevenueDto;
    TotalObjectiveDto totalObjectiveDto;
    TotalBalanceDto totalBalanceDto;
    AggregateExpendituresDto aggregateExpendituresDto;

}
