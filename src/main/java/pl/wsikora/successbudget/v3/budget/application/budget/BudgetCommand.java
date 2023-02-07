package pl.wsikora.successbudget.v3.budget.application.budget;

import pl.wsikora.successbudget.v3.common.type.Username;

import java.time.YearMonth;


public interface BudgetCommand {

    void create(YearMonth period, Username username);

}
