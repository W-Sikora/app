package pl.wsikora.successbudget.v3.common.budget;

import pl.wsikora.successbudget.v3.common.dashboard.DashboardDetailsDto;


public interface BudgetService {

    BudgetId create(DashboardDetailsDto dashboardDetailsDto);

}
