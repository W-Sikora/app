package pl.wsikora.successbudget.v3.common.currencyrate;

import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;

import java.util.List;


public interface CurrencyRateConverter {

    Money convert(Money money, Currency toCurrency);

    Money convert(List<Money> moneys, Currency toCurrency);

}
