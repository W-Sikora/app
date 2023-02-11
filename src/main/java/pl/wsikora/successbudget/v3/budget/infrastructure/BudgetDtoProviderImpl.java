package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.domain.Budget;
import pl.wsikora.successbudget.v3.common.budget.BudgetDto;
import pl.wsikora.successbudget.v3.common.budget.BudgetDtoProvider;
import pl.wsikora.successbudget.v3.common.budget.BudgetId;
import pl.wsikora.successbudget.v3.common.currencyrate.CurrencyRateConverter;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.currency.MajorCurrencyProvider;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;
import pl.wsikora.successbudget.v3.common.util.exception.NotFoundException;

import java.util.List;


@Service
class BudgetDtoProviderImpl implements BudgetDtoProvider {

    private final BudgetRepository budgetRepository;
    private final PlannedExpenditureRepository plannedExpenditureRepository;
    private final PlannedRevenueRepository plannedRevenueRepository;
    private final CurrencyRateConverter currencyRateConverter;
    private final MajorCurrencyProvider majorCurrencyProvider;

    private BudgetDtoProviderImpl(BudgetRepository budgetRepository,
                                  PlannedExpenditureRepository plannedExpenditureRepository,
                                  PlannedRevenueRepository plannedRevenueRepository,
                                  CurrencyRateConverter currencyRateConverter,
                                  MajorCurrencyProvider majorCurrencyProvider) {

        this.budgetRepository = budgetRepository;
        this.plannedExpenditureRepository = plannedExpenditureRepository;
        this.plannedRevenueRepository = plannedRevenueRepository;
        this.currencyRateConverter = currencyRateConverter;
        this.majorCurrencyProvider = majorCurrencyProvider;
    }

    @Override
    public BudgetDto provideBudgetDto(BudgetId budgetId) {

        Assert.notNull(budgetId, "BudgetId must not be null");

        Long value = budgetId.getValue();

        Budget budget = budgetRepository.findByBudgetId(value)
            .orElseThrow(() -> new NotFoundException("Budget", value));

        Currency majorCurrency = majorCurrencyProvider.getMajorCurrencyOrDefault();

        List<Money> plannedExpenditureTotalMoney = plannedExpenditureRepository.findAllMoney(value);

        MoneyDto totalPlannedExpenditures = currencyRateConverter.convert(plannedExpenditureTotalMoney, majorCurrency);

        List<Money> plannedRevenueTotalMoney = plannedRevenueRepository.findAllMoney(value);

        MoneyDto totalPlannedRevenues = currencyRateConverter.convert(plannedRevenueTotalMoney, majorCurrency);

        Money balanceValue = totalPlannedRevenues.getMoney().subtract(totalPlannedExpenditures.getMoney());

        MoneyDto balance = MoneyDtoFactory.create(balanceValue);

        return new BudgetDto(
            budget.getBudgetId(),
            budget.getPeriod().toString(),
            totalPlannedExpenditures,
            totalPlannedRevenues,
            balance
        );
    }

}

