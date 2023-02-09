package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetCommand;
import pl.wsikora.successbudget.v3.budget.domain.Budget;
import pl.wsikora.successbudget.v3.common.username.Username;

import java.time.YearMonth;


@Service
class BudgetCommandImpl implements BudgetCommand {

    private final BudgetRepository budgetRepository;

    private BudgetCommandImpl(BudgetRepository budgetRepository) {

        this.budgetRepository = budgetRepository;
    }

    @Override
    public void create(YearMonth period, Username username) {

        Budget budget = new Budget();
        budget.setPeriod(period);
        budget.setOwner(username);

        budgetRepository.save(budget);
    }
}
