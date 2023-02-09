package pl.wsikora.successbudget.v3.common.budget;

import java.time.YearMonth;


public interface BudgetService {

    BudgetId create(YearMonth yearMonth);

}
