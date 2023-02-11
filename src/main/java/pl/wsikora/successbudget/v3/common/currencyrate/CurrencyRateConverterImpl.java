package pl.wsikora.successbudget.v3.common.currencyrate;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;


@Service
class CurrencyRateConverterImpl implements CurrencyRateConverter {

    private final MockCurrencyRate mockCurrencyRate = new MockCurrencyRate();

    @Override
    public MoneyDto convert(Money money, Currency toCurrency) {

        Assert.notNull(money, "money must not be null");
        Assert.notNull(toCurrency, "toCurrency must not be null");

        Money convertedMoney = doConvert(money, toCurrency);

        return MoneyDtoFactory.create(money);
    }

    @Override
    public MoneyDto convert(@Nullable List<Money> moneys, Currency toCurrency) {

        Assert.notNull(toCurrency, "toCurrency must not be null");

        if (isEmpty(moneys)) {

            Money newMoney = Money.of(toCurrency);

            return MoneyDtoFactory.create(newMoney);
        }

        Money totalMoney = moneys.stream()
            .map(money -> doConvert(money, toCurrency))
            .reduce(Money.of(toCurrency), Money::add);

        return MoneyDtoFactory.create(totalMoney);
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
