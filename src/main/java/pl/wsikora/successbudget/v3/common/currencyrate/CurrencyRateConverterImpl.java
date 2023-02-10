package pl.wsikora.successbudget.v3.common.currencyrate;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDtoFactory;

import java.math.BigDecimal;
import java.util.List;


@Service
class CurrencyRateConverterImpl implements CurrencyRateConverter {

    private final MockCurrencyRate mockCurrencyRate = new MockCurrencyRate();

    @Override
    public MoneyDto convert(Money money, Currency toCurrency) {

        Assert.notNull(money, "money must not be null");
        Assert.notNull(toCurrency, "toCurrency must not be null");

        Money newMoney = doConvert(money, toCurrency);

        return MoneyDtoFactory.convert(newMoney);
    }

    @Override
    public MoneyDto convert(List<Money> moneys, Currency toCurrency) {

        Assert.notEmpty(moneys, "moneys must not be null");
        Assert.notNull(toCurrency, "toCurrency must not be null");

        BigDecimal total = moneys.stream()
            .map(money -> doConvert(money, toCurrency))
            .map(Money::getValue)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        Money newMoney = new Money(toCurrency, total);

        return MoneyDtoFactory.convert(newMoney);
    }

    private Money doConvert(Money money, Currency toCurrency) {

        BigDecimal convertRate = mockCurrencyRate.convert(money.getCurrency(), toCurrency);

        return new Money(
            toCurrency,
            money.getValue().multiply(convertRate)
        );
    }

}
