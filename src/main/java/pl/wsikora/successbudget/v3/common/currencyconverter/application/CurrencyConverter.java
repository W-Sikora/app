package pl.wsikora.successbudget.v3.common.currencyconverter.application;

import pl.wsikora.successbudget.v3.common.type.Currency;

import java.math.BigDecimal;


public interface CurrencyConverter {

    BigDecimal convert(Currency fromCurrency, Currency toCurrency);

}
