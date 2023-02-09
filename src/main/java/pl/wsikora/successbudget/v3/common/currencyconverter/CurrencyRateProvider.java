package pl.wsikora.successbudget.v3.common.currencyconverter;

import pl.wsikora.successbudget.v3.common.type.Currency;

import java.math.BigDecimal;


public interface CurrencyRateProvider {

    BigDecimal convert(Currency fromCurrency, Currency toCurrency);

}
