package pl.wsikora.successbudget.v3.budget.application.budget;

import java.time.YearMonth;


public interface BudgetDtoProvider {

    BudgetDto provideBudgetDto(YearMonth period);

}
