package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.budget.domain.Budget;
import pl.wsikora.successbudget.v3.common.budget.BudgetId;
import pl.wsikora.successbudget.v3.common.budget.BudgetService;
import pl.wsikora.successbudget.v3.common.username.UsernameProvider;

import java.time.YearMonth;


@Service
class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;
    private final UsernameProvider usernameProvider;

    private BudgetServiceImpl(BudgetRepository budgetRepository,
                              UsernameProvider usernameProvider) {

        this.budgetRepository = budgetRepository;
        this.usernameProvider = usernameProvider;
    }

    @Override
    public BudgetId create(YearMonth period) {

        Budget budget = new Budget();
        budget.setPeriod(period);
        budget.setOwner(usernameProvider.getUsername());

        budgetRepository.save(budget);

        return new BudgetId(budget.getBudgetId());
    }



}
