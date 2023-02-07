package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetDto;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetQuery;
import pl.wsikora.successbudget.v3.budget.domain.Budget;

import java.time.YearMonth;


@Service
class BudgetQueryImpl implements BudgetQuery {

    private final BudgetRepository budgetRepository;

    private BudgetQueryImpl(BudgetRepository budgetRepository) {

        this.budgetRepository = budgetRepository;
    }

    public BudgetDto getByPeriod(YearMonth period) {

        return toDto(budgetRepository.getByPeriod(period));
    }

    private BudgetDto toDto(Budget budget) {

        return new BudgetDto(
            budget.getBudgetId(),
            budget.getPeriod().toString()
        );
    }
}
