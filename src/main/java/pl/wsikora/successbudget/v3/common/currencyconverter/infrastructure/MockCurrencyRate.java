package pl.wsikora.successbudget.v3.common.currencyconverter.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.common.currencyconverter.CurrencyRateProvider;
import pl.wsikora.successbudget.v3.common.type.Currency;

import java.math.BigDecimal;


@Service
class MockCurrencyRate implements CurrencyRateProvider {

    @Override
    public BigDecimal convert(Currency fromCurrency, Currency toCurrency) {

        if (fromCurrency.isPln()) {

            if (toCurrency.isEur()) {

                return new BigDecimal("4.75");
            }

            if (toCurrency.isUsd()) {

                return new BigDecimal("4.43");
            }

            if (toCurrency.isGbp()) {

                return new BigDecimal("5.33");
            }

            if (toCurrency.isChf()) {

                return new BigDecimal("4.77");
            }

            throw new UnknownCurrencyException();
        }

        if (fromCurrency.isEur()) {

            if (toCurrency.isPln()) {

                return new BigDecimal("0.21");
            }

            if (toCurrency.isUsd()) {

                return new BigDecimal("0.93");
            }

            if (toCurrency.isGbp()) {

                return new BigDecimal("1.12");
            }

            if (toCurrency.isChf()) {

                return new BigDecimal("1.01");
            }

            throw new UnknownCurrencyException();
        }

        if (fromCurrency.isUsd()) {

            if (toCurrency.isEur()) {

                return new BigDecimal("1.07");
            }

            if (toCurrency.isPln()) {

                return new BigDecimal("0.23");
            }

            if (toCurrency.isGbp()) {

                return new BigDecimal("1.20");
            }

            if (toCurrency.isChf()) {

                return new BigDecimal("1.08");
            }

            throw new UnknownCurrencyException();
        }

        if (fromCurrency.isGbp()) {

            if (toCurrency.isEur()) {

                return new BigDecimal("0.89");
            }

            if (toCurrency.isUsd()) {

                return new BigDecimal("0.83");
            }

            if (toCurrency.isPln()) {

                return new BigDecimal("0.19");
            }

            if (toCurrency.isChf()) {

                return new BigDecimal("0.90");
            }

            throw new UnknownCurrencyException();
        }

        if (fromCurrency.isChf()) {

            if (toCurrency.isEur()) {

                return new BigDecimal("0.99");
            }

            if (toCurrency.isUsd()) {

                return new BigDecimal("0.93");
            }

            if (toCurrency.isGbp()) {

                return new BigDecimal("1.12");
            }

            if (toCurrency.isPln()) {

                return new BigDecimal("0.21");
            }

            throw new UnknownCurrencyException();
        }

        throw new UnknownCurrencyException();
    }

}
