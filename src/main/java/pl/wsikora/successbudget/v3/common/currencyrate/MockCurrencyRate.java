package pl.wsikora.successbudget.v3.common.currencyrate;

import pl.wsikora.successbudget.v3.common.type.currency.Currency;

import java.math.BigDecimal;


class MockCurrencyRate {

    BigDecimal convert(Currency fromCurrency, Currency toCurrency) {

        if (fromCurrency.isPln()) {

            if (toCurrency.isEur()) {

                return new BigDecimal("0.21");
            }

            if (toCurrency.isUsd()) {

                return new BigDecimal("0.22");
            }

            if (toCurrency.isGbp()) {

                return new BigDecimal("0.19");
            }

            if (toCurrency.isChf()) {

                return new BigDecimal("0.21");
            }

            throw new UnknownCurrencyException();
        }

        if (fromCurrency.isEur()) {

            if (toCurrency.isPln()) {

                return new BigDecimal("4.78");
            }

            if (toCurrency.isUsd()) {

                return new BigDecimal("1.07");
            }

            if (toCurrency.isGbp()) {

                return new BigDecimal("0.89");
            }

            if (toCurrency.isChf()) {

                return new BigDecimal("0.99");
            }

            throw new UnknownCurrencyException();
        }

        if (fromCurrency.isUsd()) {

            if (toCurrency.isEur()) {

                return new BigDecimal("0.93");
            }

            if (toCurrency.isPln()) {

                return new BigDecimal("4.47");
            }

            if (toCurrency.isGbp()) {

                return new BigDecimal("0.83");
            }

            if (toCurrency.isChf()) {

                return new BigDecimal("0.92");
            }

            throw new UnknownCurrencyException();
        }

        if (fromCurrency.isGbp()) {

            if (toCurrency.isEur()) {

                return new BigDecimal("1.13");
            }

            if (toCurrency.isUsd()) {

                return new BigDecimal("1.21");
            }

            if (toCurrency.isPln()) {

                return new BigDecimal("5.39");
            }

            if (toCurrency.isChf()) {

                return new BigDecimal("1.12");
            }

            throw new UnknownCurrencyException();
        }

        if (fromCurrency.isChf()) {

            if (toCurrency.isEur()) {

                return new BigDecimal("1.01");
            }

            if (toCurrency.isUsd()) {

                return new BigDecimal("1.08");
            }

            if (toCurrency.isGbp()) {

                return new BigDecimal("0.90");
            }

            if (toCurrency.isPln()) {

                return new BigDecimal("4.83");
            }

            throw new UnknownCurrencyException();
        }

        throw new UnknownCurrencyException();
    }

}
