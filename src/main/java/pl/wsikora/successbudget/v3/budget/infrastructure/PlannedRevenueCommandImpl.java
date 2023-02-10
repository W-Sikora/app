package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueAttributes;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;
import pl.wsikora.successbudget.v3.budget.domain.Budget;
import pl.wsikora.successbudget.v3.budget.domain.PlannedRevenue;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.money.Money;


@Service
class PlannedRevenueCommandImpl implements PlannedRevenueCommand {

    private final PlannedRevenueRepository plannedRevenueRepository;
    private final UsernameProvider usernameProvider;
    private final BudgetRepository budgetRepository;

    private PlannedRevenueCommandImpl(PlannedRevenueRepository plannedRevenueRepository,
                                      UsernameProvider usernameProvider,
                                      BudgetRepository budgetRepository) {

        this.plannedRevenueRepository = plannedRevenueRepository;
        this.usernameProvider = usernameProvider;
        this.budgetRepository = budgetRepository;
    }

    @Override
    public void save(PlannedRevenueAttributes plannedRevenueAttributes) {

        Assert.notNull(plannedRevenueAttributes, "plannedRevenueAttributes must not be null");

        PlannedRevenue plannedRevenue = new PlannedRevenue();

        Budget budget = getBudgetByBudgetId(plannedRevenueAttributes.getBudgetId());

        plannedRevenue.setBudget(budget);

        plannedRevenue.setOwner(usernameProvider.getUsername());

        CategoryId categoryId = new CategoryId(plannedRevenueAttributes.getCategoryId());

        plannedRevenue.setCategoryId(categoryId);

        Currency currency = new Currency(plannedRevenueAttributes.getCurrency());

        Money money = new Money(
            currency,
            plannedRevenueAttributes.getValue()
        );

        plannedRevenue.setMoney(money);

        plannedRevenue.setRepeatInNextPeriod(plannedRevenueAttributes.isRepeatInNextPeriod());

        plannedRevenueRepository.save(plannedRevenue);
    }

    @Override
    public void delete(Long plannedExpenditureId) {

        Assert.notNull(plannedExpenditureId, "plannedExpenditureId must not be null");

        plannedRevenueRepository.delete(plannedExpenditureId);
    }

    @Override
    public void repeat(Long fromBudgetId, Long toBudgetId) {

        Assert.notNull(fromBudgetId, "fromBudgetId must not be null");
        Assert.notNull(toBudgetId, "toBudgetId must not be null");

        plannedRevenueRepository.findAllRepeated(fromBudgetId)
            .stream()
            .map(this::assignBudget)
            .forEach(plannedRevenueRepository::save);
    }

    private PlannedRevenue assignBudget(PlannedRevenue plannedRevenue) {

        Long budgetId = plannedRevenue.getBudget().getBudgetId();

        Budget budget = getBudgetByBudgetId(budgetId);

        plannedRevenue.setBudget(budget);

        return plannedRevenue;
    }

    private Budget getBudgetByBudgetId(Long budgetId) {

        return budgetRepository.findByBudgetId(budgetId)
            .orElseThrow(() -> new NotFoundException("budget", budgetId));
    }

}
