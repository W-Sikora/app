package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetDto;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetDtoProvider;
import pl.wsikora.successbudget.v3.common.currencyrate.CurrencyRateConverter;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.currency.MajorCurrencyProvider;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;

import java.time.YearMonth;
import java.util.List;

import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;


@Service
class BudgetDtoProviderImpl implements BudgetDtoProvider {

    private final PlannedExpenditureRepository plannedExpenditureRepository;
    private final PlannedRevenueRepository plannedRevenueRepository;
    private final CurrencyRateConverter currencyRateConverter;
    private final MajorCurrencyProvider majorCurrencyProvider;

    private BudgetDtoProviderImpl(
        PlannedExpenditureRepository plannedExpenditureRepository,
        PlannedRevenueRepository plannedRevenueRepository,
        CurrencyRateConverter currencyRateConverter,
        MajorCurrencyProvider majorCurrencyProvider
    ) {

        this.plannedExpenditureRepository = plannedExpenditureRepository;
        this.plannedRevenueRepository = plannedRevenueRepository;
        this.currencyRateConverter = currencyRateConverter;
        this.majorCurrencyProvider = majorCurrencyProvider;
    }

    @Override
    public BudgetDto provideBudgetDto(YearMonth period) {

        Assert.notNull(period, "period must not be null");

        Currency majorCurrency = majorCurrencyProvider.getMajorCurrencyOrDefault();

        List<Money> plannedExpenditureTotalMoney = plannedExpenditureRepository.findAllMoney(period);

        Money totalPlannedExpenditures = currencyRateConverter.convert(plannedExpenditureTotalMoney, majorCurrency);

        List<Money> plannedRevenueTotalMoney = plannedRevenueRepository.findAllMoney(period);

        Money totalPlannedRevenues = currencyRateConverter.convert(plannedRevenueTotalMoney, majorCurrency);

        Money balanceValue = totalPlannedRevenues.subtract(totalPlannedExpenditures);

        return new BudgetDto(
            period.format(PERIOD_FORMATTER),
            MoneyDtoFactory.create(totalPlannedExpenditures),
            MoneyDtoFactory.create(totalPlannedRevenues),
            MoneyDtoFactory.create(balanceValue)
        );
    }

}

