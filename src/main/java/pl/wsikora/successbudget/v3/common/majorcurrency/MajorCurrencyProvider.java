package pl.wsikora.successbudget.v3.common.majorcurrency;

import pl.wsikora.successbudget.v3.common.type.Currency;


public interface MajorCurrencyProvider {

    Currency getMajorCurrencyOrDefault();

    Currency getMajorCurrency();

}
