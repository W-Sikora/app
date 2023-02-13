package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.repeat.RepeatCommand;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueAttributes;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueCommand;
import pl.wsikora.successbudget.v3.budget.domain.PlannedRevenue;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;

import java.time.YearMonth;


@Service
class PlannedPlannedRevenueCommandImpl implements PlannedRevenueCommand {

    private final UsernameProvider usernameProvider;
    private final PlannedRevenueRepository plannedRevenueRepository;

    private PlannedPlannedRevenueCommandImpl(
        UsernameProvider usernameProvider,
        PlannedRevenueRepository plannedRevenueRepository
    ) {

        this.usernameProvider = usernameProvider;
        this.plannedRevenueRepository = plannedRevenueRepository;
    }

    @Override
    public void save(PlannedRevenueAttributes plannedRevenueAttributes) {

        Assert.notNull(plannedRevenueAttributes, "plannedRevenueAttributes must not be null");

        PlannedRevenue plannedRevenue = new PlannedRevenue();

        plannedRevenue.setPlannedRevenueId(plannedRevenueAttributes.getPlannedRevenueId());

        plannedRevenue.setPeriod(plannedRevenueAttributes.getPeriod());

        plannedRevenue.setOwner(usernameProvider.getUsername());

        CategoryId categoryId = CategoryId.of(plannedRevenueAttributes.getCategoryId());

        plannedRevenue.setCategoryId(categoryId);

        Currency currency = Currency.of(plannedRevenueAttributes.getCurrency());

        Money money = Money.of(currency, plannedRevenueAttributes.getValue());

        plannedRevenue.setMoney(money);

        plannedRevenue.setRepeatInNextPeriod(plannedRevenueAttributes.isRepeatInNextPeriod());

        plannedRevenueRepository.save(plannedRevenue);
    }

    @Override
    public void delete(Long plannedRevenueId) {

        Assert.notNull(plannedRevenueId, "plannedRevenueId must not be null");

        plannedRevenueRepository.delete(plannedRevenueId);
    }

    @Override
    public void repeat(RepeatCommand repeatCommand) {

        Assert.notNull(repeatCommand, "budgetRepeatCommand must not be null");

        plannedRevenueRepository.findRepeatable(repeatCommand.fromPeriod())
            .stream()
            .map(plannedRevenue -> assignBudget(plannedRevenue, repeatCommand.toPeriod()))
            .forEach(plannedRevenueRepository::save);
    }

    private PlannedRevenue assignBudget(PlannedRevenue plannedRevenue, YearMonth toperiod) {

        plannedRevenue.setPlannedRevenueId(null);

        plannedRevenue.setPeriod(toperiod);

        return plannedRevenue;
    }

}
