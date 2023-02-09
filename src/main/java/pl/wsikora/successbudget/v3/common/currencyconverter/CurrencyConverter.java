package pl.wsikora.successbudget.v3.common.currencyconverter;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.money.Money;
import pl.wsikora.successbudget.v3.common.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.money.MoneyDtoConverter;
import pl.wsikora.successbudget.v3.common.type.Currency;

import java.math.BigDecimal;
import java.util.List;


@Service
public class CurrencyConverter {

    private final CurrencyRateProvider currencyRateProvider;

    private CurrencyConverter(CurrencyRateProvider currencyRateProvider) {

        this.currencyRateProvider = currencyRateProvider;
    }

    public MoneyDto convert(Money money, Currency toCurrency) {

        Assert.notNull(money, "money must not be null");
        Assert.notNull(toCurrency, "toCurrency must not be null");

        Money newMoney = doConvert(money, toCurrency);

        return MoneyDtoConverter.convert(newMoney);
    }

    public MoneyDto convert(List<Money> moneys, Currency toCurrency) {

        Assert.notEmpty(moneys, "moneys must not be null");
        Assert.notNull(toCurrency, "toCurrency must not be null");

        BigDecimal total = moneys.stream()
            .map(money -> doConvert(money, toCurrency))
            .map(Money::getValue)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        Money newMoney = new Money(toCurrency, total);

        return MoneyDtoConverter.convert(newMoney);
    }

    private Money doConvert(Money money, Currency toCurrency) {

        BigDecimal convertRate = currencyRateProvider.convert(money.getCurrency(), toCurrency);

        return new Money(
            toCurrency,
            money.getValue().multiply(convertRate)
        );
    }

}
