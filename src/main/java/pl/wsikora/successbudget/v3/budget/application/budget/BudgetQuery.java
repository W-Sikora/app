package pl.wsikora.successbudget.v3.budget.application.budget;

import pl.wsikora.successbudget.v3.common.budget.BudgetDto;

import java.util.Optional;


public interface BudgetQuery {

    Optional<BudgetDto> findByBudgetId(Long budgetId);

}
