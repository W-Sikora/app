package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureAttributes;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;
import pl.wsikora.successbudget.v3.budget.domain.Budget;
import pl.wsikora.successbudget.v3.budget.domain.PlannedExpenditure;
import pl.wsikora.successbudget.v3.common.username.UsernameProvider;
import pl.wsikora.successbudget.v3.common.exception.NotFoundException;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.Currency;
import pl.wsikora.successbudget.v3.common.money.Money;
import pl.wsikora.successbudget.v3.common.type.Priority;


@Service
class PlannedExpenditureCommandImpl implements PlannedExpenditureCommand {

    private final PlannedExpenditureRepository plannedExpenditureRepository;
    private final UsernameProvider usernameProvider;
    private final BudgetRepository budgetRepository;

    private PlannedExpenditureCommandImpl(PlannedExpenditureRepository plannedExpenditureRepository,
                                          UsernameProvider usernameProvider,
                                          BudgetRepository budgetRepository) {

        this.plannedExpenditureRepository = plannedExpenditureRepository;
        this.usernameProvider = usernameProvider;
        this.budgetRepository = budgetRepository;
    }

    @Override
    public void save(PlannedExpenditureAttributes plannedExpenditureAttributes) {

        Assert.notNull(plannedExpenditureAttributes, "plannedExpenditureAttributes must not be null");

        PlannedExpenditure plannedExpenditure = new PlannedExpenditure();

        Budget budget = getBudgetByBudgetId(plannedExpenditureAttributes.getBudgetId());

        plannedExpenditure.setBudget(budget);

        plannedExpenditure.setOwner(usernameProvider.getUsername());

        CategoryId categoryId = new CategoryId(plannedExpenditureAttributes.getCategoryId());

        plannedExpenditure.setCategoryId(categoryId);

        Priority priority = Priority.getByPriorityId(plannedExpenditureAttributes.getPriorityId());

        plannedExpenditure.setPriority(priority);

        Currency currency = Currency.getByCurrencyId(plannedExpenditureAttributes.getCurrencyId());

        Money money = new Money(
            currency,
            plannedExpenditureAttributes.getValue()
        );

        plannedExpenditure.setMoney(money);

        plannedExpenditure.setRepeatInNextPeriod(plannedExpenditureAttributes.isRepeatInNextPeriod());

        plannedExpenditureRepository.save(plannedExpenditure);
    }

    @Override
    public void delete(Long plannedExpenditureId) {

        Assert.notNull(plannedExpenditureId, "plannedExpenditureId must not be null");

        plannedExpenditureRepository.delete(plannedExpenditureId);
    }

    @Override
    public void repeat(Long fromBudgetId, Long toBudgetId) {

        Assert.notNull(fromBudgetId, "fromBudgetId must not be null");
        Assert.notNull(toBudgetId, "toBudgetId must not be null");

        plannedExpenditureRepository.findAllRepeated(fromBudgetId)
            .stream()
            .map(this::assignBudget)
            .forEach(plannedExpenditureRepository::save);
    }

    private PlannedExpenditure assignBudget(PlannedExpenditure plannedExpenditure) {

        Budget budget = getBudgetByBudgetId(plannedExpenditure.getBudget().getBudgetId());

        plannedExpenditure.setBudget(budget);

        return plannedExpenditure;
    }

    private Budget getBudgetByBudgetId(Long budgetId) {

        return budgetRepository.findByBudgetId(budgetId)
            .orElseThrow(() -> new NotFoundException("budget", budgetId));
    }

}
