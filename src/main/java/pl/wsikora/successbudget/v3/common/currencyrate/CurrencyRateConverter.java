package pl.wsikora.successbudget.v3.common.currencyrate;

import pl.wsikora.successbudget.v3.common.type.currency.Currency;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;

import java.util.List;


public interface CurrencyRateConverter {

    MoneyDto convert(Money money, Currency toCurrency);

    MoneyDto convert(List<Money> moneys, Currency toCurrency);

}
