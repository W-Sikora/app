package pl.wsikora.successbudget.v3.common.type.currency;

public interface MajorCurrencyProvider {

    Currency getMajorCurrencyOrDefault();

    Currency getMajorCurrency();

}
