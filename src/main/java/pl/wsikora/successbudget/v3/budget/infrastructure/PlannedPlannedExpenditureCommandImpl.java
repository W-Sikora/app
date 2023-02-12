package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetRepeatCommand;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureAttributes;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureDeleteCommand;
import pl.wsikora.successbudget.v3.budget.domain.Budget;
import pl.wsikora.successbudget.v3.budget.domain.PlannedExpenditure;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.priority.Priority;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;


@Service
class PlannedPlannedExpenditureCommandImpl implements PlannedExpenditureCommand {

    private final UsernameProvider usernameProvider;
    private final PlannedExpenditureRepository plannedExpenditureRepository;
    private final BudgetRepository budgetRepository;

    private PlannedPlannedExpenditureCommandImpl(UsernameProvider usernameProvider,
                                                 PlannedExpenditureRepository plannedExpenditureRepository,
                                                 BudgetRepository budgetRepository) {

        this.usernameProvider = usernameProvider;
        this.plannedExpenditureRepository = plannedExpenditureRepository;
        this.budgetRepository = budgetRepository;
    }

    @Override
    public void save(PlannedExpenditureAttributes plannedExpenditureAttributes) {

        Assert.notNull(plannedExpenditureAttributes, "plannedExpenditureAttributes must not be null");

        PlannedExpenditure plannedExpenditure = new PlannedExpenditure();

        plannedExpenditure.setPlannedExpenditureId(plannedExpenditureAttributes.getPlannedExpenditureId());

        Budget budget = getBudgetByBudgetId(plannedExpenditureAttributes.getBudgetId());

        plannedExpenditure.setBudget(budget);

        plannedExpenditure.setOwner(usernameProvider.getUsername());

        CategoryId categoryId = new CategoryId(plannedExpenditureAttributes.getCategoryId());

        plannedExpenditure.setCategoryId(categoryId);

        Priority priority = Priority.of(plannedExpenditureAttributes.getPriority());

        plannedExpenditure.setPriority(priority);

        Currency currency = Currency.of(plannedExpenditureAttributes.getCurrency());

        Money money = Money.of(
            currency,
            plannedExpenditureAttributes.getValue()
        );

        plannedExpenditure.setMoney(money);

        plannedExpenditure.setRepeatInNextPeriod(plannedExpenditureAttributes.isRepeatInNextPeriod());

        plannedExpenditureRepository.save(plannedExpenditure);
    }

    @Override
    public void delete(PlannedExpenditureDeleteCommand plannedExpenditureDeleteCommand) {

        Assert.notNull(plannedExpenditureDeleteCommand, "deleteCommand must not be null");

        plannedExpenditureRepository.delete(
            plannedExpenditureDeleteCommand.budgetId(),
            plannedExpenditureDeleteCommand.plannedExpenditureId()
        );
    }

    @Override
    public void repeat(BudgetRepeatCommand budgetRepeatCommand) {

        Assert.notNull(budgetRepeatCommand, "budgetRepeatCommand must not be null");

        plannedExpenditureRepository.findAllRepeated(budgetRepeatCommand.fromBudgetId())
            .stream()
            .map(plannedExpenditure -> assignToBudget(plannedExpenditure, budgetRepeatCommand.toBudgetId()))
            .forEach(plannedExpenditureRepository::save);
    }

    private Budget getBudgetByBudgetId(Long budgetId) {

        return budgetRepository.findByBudgetId(budgetId)
            .orElseThrow(() -> new NotFoundException("budget", budgetId));
    }

    private PlannedExpenditure assignToBudget(PlannedExpenditure plannedExpenditure, Long toBudgetId) {

        Budget budget = getBudgetByBudgetId(toBudgetId);

        plannedExpenditure.setBudget(budget);

        return plannedExpenditure;
    }

}
