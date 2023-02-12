package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetChecker;


@Service
public class BudgetCheckerImpl implements BudgetChecker {

    private final BudgetRepository budgetRepository;

    private BudgetCheckerImpl(BudgetRepository budgetRepository) {

        this.budgetRepository = budgetRepository;
    }

    @Override
    public boolean hasNoBudget(Long budgetId) {

        return !budgetRepository.hasBudget(budgetId);
    }

}
