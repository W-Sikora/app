package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.domain.Budget;
import pl.wsikora.successbudget.v3.common.budget.BudgetDto;
import pl.wsikora.successbudget.v3.common.budget.BudgetDtoProvider;
import pl.wsikora.successbudget.v3.common.budget.BudgetId;
import pl.wsikora.successbudget.v3.common.currencyconverter.CurrencyConverter;
import pl.wsikora.successbudget.v3.common.exception.NotFoundException;
import pl.wsikora.successbudget.v3.common.majorcurrency.MajorCurrencyProvider;
import pl.wsikora.successbudget.v3.common.money.Money;
import pl.wsikora.successbudget.v3.common.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.Currency;

import java.util.List;


@Service
class BudgetDtoProviderImpl implements BudgetDtoProvider {

    private final BudgetRepository budgetRepository;
    private final PlannedExpenditureRepository plannedExpenditureRepository;
    private final PlannedRevenueRepository plannedRevenueRepository;
    private final CurrencyConverter currencyConverter;
    private final MajorCurrencyProvider majorCurrencyProvider;

    private BudgetDtoProviderImpl(BudgetRepository budgetRepository,
                                  PlannedExpenditureRepository plannedExpenditureRepository,
                                  PlannedRevenueRepository plannedRevenueRepository,
                                  CurrencyConverter currencyConverter,
                                  MajorCurrencyProvider majorCurrencyProvider) {

        this.budgetRepository = budgetRepository;
        this.plannedExpenditureRepository = plannedExpenditureRepository;
        this.plannedRevenueRepository = plannedRevenueRepository;
        this.currencyConverter = currencyConverter;
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

        MoneyDto totalPlannedExpenditures = currencyConverter.convert(plannedExpenditureTotalMoney, majorCurrency);

        List<Money> plannedRevenueTotalMoney = plannedRevenueRepository.findAllMoney(value);

        MoneyDto totalPlannedRevenues = currencyConverter.convert(plannedRevenueTotalMoney, majorCurrency);

        return new BudgetDto(
            budget.getBudgetId(),
            budget.getPeriod().toString(),
            totalPlannedExpenditures,
            totalPlannedRevenues
        );
    }

}

