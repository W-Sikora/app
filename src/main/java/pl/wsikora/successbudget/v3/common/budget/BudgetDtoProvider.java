package pl.wsikora.successbudget.v3.common.budget;

import java.time.YearMonth;


public interface BudgetDtoProvider {

    BudgetDto provideBudgetDto(YearMonth period);

}
