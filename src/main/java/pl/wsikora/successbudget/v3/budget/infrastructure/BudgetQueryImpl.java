package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetDto;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetQuery;
import pl.wsikora.successbudget.v3.budget.domain.Budget;

import java.util.Optional;


@Service
class BudgetQueryImpl implements BudgetQuery {

    private final BudgetRepository budgetRepository;

    private BudgetQueryImpl(BudgetRepository budgetRepository) {

        this.budgetRepository = budgetRepository;
    }

    @Override
    public Optional<BudgetDto> findByBudgetId(Long budgetId) {

        return budgetRepository.findByBudgetId(budgetId)
            .map(this::toDto);
    }

    private BudgetDto toDto(Budget budget) {

        return new BudgetDto(
            budget.getBudgetId(),
            budget.getPeriod().toString()
        );
    }

}
