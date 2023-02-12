package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetRepeatCommand;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueAttributes;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueDeleteCommand;
import pl.wsikora.successbudget.v3.budget.domain.Budget;
import pl.wsikora.successbudget.v3.budget.domain.PlannedRevenue;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;


@Service
class PlannedPlannedRevenueCommandImpl implements PlannedRevenueCommand {

    private final UsernameProvider usernameProvider;
    private final PlannedRevenueRepository plannedRevenueRepository;
    private final BudgetRepository budgetRepository;

    private PlannedPlannedRevenueCommandImpl(UsernameProvider usernameProvider,
                                             PlannedRevenueRepository plannedRevenueRepository,
                                             BudgetRepository budgetRepository) {

        this.usernameProvider = usernameProvider;
        this.plannedRevenueRepository = plannedRevenueRepository;
        this.budgetRepository = budgetRepository;
    }

    @Override
    public void save(PlannedRevenueAttributes plannedRevenueAttributes) {

        Assert.notNull(plannedRevenueAttributes, "plannedRevenueAttributes must not be null");

        PlannedRevenue plannedRevenue = new PlannedRevenue();

        plannedRevenue.setPlannedRevenueId(plannedRevenueAttributes.getPlannedRevenueId());

        Budget budget = getBudgetByBudgetId(plannedRevenueAttributes.getBudgetId());

        plannedRevenue.setBudget(budget);

        plannedRevenue.setOwner(usernameProvider.getUsername());

        CategoryId categoryId = new CategoryId(plannedRevenueAttributes.getCategoryId());

        plannedRevenue.setCategoryId(categoryId);

        Currency currency = Currency.of(plannedRevenueAttributes.getCurrency());

        Money money = Money.of(
            currency,
            plannedRevenueAttributes.getValue()
        );

        plannedRevenue.setMoney(money);

        plannedRevenue.setRepeatInNextPeriod(plannedRevenueAttributes.isRepeatInNextPeriod());

        plannedRevenueRepository.save(plannedRevenue);
    }

    @Override
    public void delete(PlannedRevenueDeleteCommand plannedRevenueDeleteCommand) {

        Assert.notNull(plannedRevenueDeleteCommand, "plannedRevenueDeleteCommand must not be null");

        plannedRevenueRepository.delete(
            plannedRevenueDeleteCommand.budgetId(),
            plannedRevenueDeleteCommand.plannedRevenueId()
        );
    }

    @Override
    public void repeat(BudgetRepeatCommand budgetRepeatCommand) {

        Assert.notNull(budgetRepeatCommand, "budgetRepeatCommand must not be null");

        plannedRevenueRepository.findAllRepeated(budgetRepeatCommand.fromBudgetId())
            .stream()
            .map(plannedRevenue -> assignBudget(plannedRevenue, budgetRepeatCommand.toBudgetId()))
            .forEach(plannedRevenueRepository::save);
    }

    private PlannedRevenue assignBudget(PlannedRevenue plannedRevenue, Long toBudgetId) {

        Budget budget = getBudgetByBudgetId(toBudgetId);

        plannedRevenue.setBudget(budget);

        return plannedRevenue;
    }

    private Budget getBudgetByBudgetId(Long budgetId) {

        return budgetRepository.findByBudgetId(budgetId)
            .orElseThrow(() -> new NotFoundException("Budget", budgetId));
    }

}
