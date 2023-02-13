package pl.wsikora.successbudget.v3.common.currencyrate;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;


@Service
class CurrencyRateConverterImpl implements CurrencyRateConverter {

    private final MockCurrencyRate mockCurrencyRate = new MockCurrencyRate();

    @Override
    public Money convert(Money money, Currency toCurrency) {

        Assert.notNull(money, "money must not be null");
        Assert.notNull(toCurrency, "toCurrency must not be null");

        return doConvert(money, toCurrency);
    }

    @Override
    public Money convert(@Nullable List<Money> moneys, Currency toCurrency) {

        Assert.notNull(toCurrency, "toCurrency must not be null");

        if (isEmpty(moneys)) {

            return Money.of(toCurrency);
        }

        return moneys.stream()
            .map(money -> doConvert(money, toCurrency))
            .reduce(Money.of(toCurrency), Money::add);
    }

    private Money doConvert(Money money, Currency toCurrency) {

        Currency fromCurrency = money.getCurrency();

        if (fromCurrency.equals(toCurrency)) {

            return money;
        }

        BigDecimal convertRate = mockCurrencyRate.convert(fromCurrency, toCurrency);

        return money.convert(toCurrency, convertRate);
    }

}
