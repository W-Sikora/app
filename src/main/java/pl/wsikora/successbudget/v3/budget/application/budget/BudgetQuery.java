package pl.wsikora.successbudget.v3.budget.application.budget;

import java.util.Optional;


public interface BudgetQuery {

    Optional<BudgetDto> findByBudgetId(Long budgetId);

}
