package pl.wsikora.successbudget.budget.application.query;

import pl.wsikora.successbudget.budget.domain.Budget;

import java.util.Optional;

public interface BudgetQuery {

    Budget getById(Long id);

    Optional<Budget> findById(Long id);
}
