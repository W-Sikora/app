package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.repeat.RepeatCommand;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureAttributes;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureCommand;
import pl.wsikora.successbudget.v3.budget.domain.PlannedExpenditure;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.priority.Priority;
import pl.wsikora.successbudget.v3.common.type.username.UsernameProvider;

import java.time.YearMonth;


@Service
class PlannedPlannedExpenditureCommandImpl implements PlannedExpenditureCommand {

    private final UsernameProvider usernameProvider;
    private final PlannedExpenditureRepository plannedExpenditureRepository;

    private PlannedPlannedExpenditureCommandImpl(
        UsernameProvider usernameProvider,
        PlannedExpenditureRepository plannedExpenditureRepository
    ) {

        this.usernameProvider = usernameProvider;
        this.plannedExpenditureRepository = plannedExpenditureRepository;
    }

    @Override
    public void save(PlannedExpenditureAttributes plannedExpenditureAttributes) {

        Assert.notNull(plannedExpenditureAttributes, "plannedExpenditureAttributes must not be null");

        PlannedExpenditure plannedExpenditure = new PlannedExpenditure();

        plannedExpenditure.setPlannedExpenditureId(plannedExpenditureAttributes.getPlannedExpenditureId());

        plannedExpenditure.setPeriod(plannedExpenditureAttributes.getPeriod());

        plannedExpenditure.setOwner(usernameProvider.getUsername());

        CategoryId categoryId = CategoryId.of(plannedExpenditureAttributes.getCategoryId());

        plannedExpenditure.setCategoryId(categoryId);

        Priority priority = Priority.of(plannedExpenditureAttributes.getPriority());

        plannedExpenditure.setPriority(priority);

        Currency currency = Currency.of(plannedExpenditureAttributes.getCurrency());

        Money money = Money.of(currency, plannedExpenditureAttributes.getValue());

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
    public void repeat(RepeatCommand repeatCommand) {

        Assert.notNull(repeatCommand, "budgetRepeatCommand must not be null");

        plannedExpenditureRepository.findRepeatable(repeatCommand.fromPeriod())
            .stream()
            .map(plannedExpenditure -> assignToBudget(plannedExpenditure, repeatCommand.toPeriod()))
            .forEach(plannedExpenditureRepository::save);
    }

    private PlannedExpenditure assignToBudget(PlannedExpenditure plannedExpenditure, YearMonth toperiod) {

        plannedExpenditure.setPlannedExpenditureId(null);

        plannedExpenditure.setPeriod(toperiod);

        return plannedExpenditure;
    }

}
