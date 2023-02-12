package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import pl.wsikora.successbudget.v3.budget.application.budget.BudgetRepeatCommand;


public interface PlannedExpenditureCommand {

    void save(PlannedExpenditureAttributes plannedExpenditureAttributes);

    void delete(PlannedExpenditureDeleteCommand plannedExpenditureDeleteCommand);

    void repeat(BudgetRepeatCommand budgetRepeatCommand);

}
