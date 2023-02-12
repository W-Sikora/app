package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import pl.wsikora.successbudget.v3.budget.application.budget.BudgetRepeatCommand;


public interface PlannedRevenueCommand {

    void save(PlannedRevenueAttributes plannedRevenueAttributes);

    void delete(PlannedRevenueDeleteCommand plannedRevenueDeleteCommand);

    void repeat(BudgetRepeatCommand budgetRepeatCommand);

}
