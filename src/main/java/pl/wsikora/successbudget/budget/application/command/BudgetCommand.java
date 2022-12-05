package pl.wsikora.successbudget.budget.application.command;

import pl.wsikora.successbudget.budget.domain.Budget;

public interface BudgetCommand {

    void save(Budget budget);

    void delete(long id);
}
