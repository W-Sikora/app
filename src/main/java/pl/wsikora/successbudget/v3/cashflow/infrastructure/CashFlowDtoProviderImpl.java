package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.cashflow.CashFlowDto;
import pl.wsikora.successbudget.v3.common.cashflow.CashFlowDtoProvider;
import pl.wsikora.successbudget.v3.common.currencyrate.CurrencyRateConverter;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.currency.MajorCurrencyProvider;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;

import java.time.YearMonth;
import java.util.List;

import static pl.wsikora.successbudget.v3.common.util.DateFormatter.PERIOD_FORMATTER;


@Service
class CashFlowDtoProviderImpl implements CashFlowDtoProvider {

    private final ExpenditureRepository expenditureRepository;
    private final RevenueRepository revenueRepository;
    private final CurrencyRateConverter currencyRateConverter;
    private final MajorCurrencyProvider majorCurrencyProvider;

    private CashFlowDtoProviderImpl(
        ExpenditureRepository expenditureRepository,
        RevenueRepository revenueRepository,
        CurrencyRateConverter currencyRateConverter,
        MajorCurrencyProvider majorCurrencyProvider
    ) {

        this.expenditureRepository = expenditureRepository;
        this.revenueRepository = revenueRepository;
        this.currencyRateConverter = currencyRateConverter;
        this.majorCurrencyProvider = majorCurrencyProvider;
    }

    @Override
    public CashFlowDto provideCashFlowDto(YearMonth period) {

        Assert.notNull(period, "period must not be null");

        Currency majorCurrency = majorCurrencyProvider.getMajorCurrencyOrDefault();

        List<Money> expenditureMoney = expenditureRepository.findAllMoney(period);

        Money totalExpenditures = currencyRateConverter.convert(expenditureMoney, majorCurrency);

        List<Money> revenueMoney = revenueRepository.findAllMoney(period);

        Money totalRevenues = currencyRateConverter.convert(revenueMoney, majorCurrency);

        Money balanceValue = totalRevenues.subtract(totalExpenditures);

        return new CashFlowDto(
            period.format(PERIOD_FORMATTER),
            MoneyDtoFactory.create(totalExpenditures),
            MoneyDtoFactory.create(totalRevenues),
            MoneyDtoFactory.create(balanceValue)
        );
    }

}

