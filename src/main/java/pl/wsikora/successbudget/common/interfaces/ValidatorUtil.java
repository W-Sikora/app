package pl.wsikora.successbudget.common.interfaces;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

public class ValidatorUtil {

    private ValidatorUtil() {

    }

    public static boolean isValidCurrencyValue(BigDecimal currencyValue) {

        return nonNull(currencyValue) &&
                currencyValue.signum() == 1 &&
                getNumberOfDecimalPlaces(currencyValue) <= 2;
    }

    private static int getNumberOfDecimalPlaces(BigDecimal bigDecimal) {

        return Math.max(0, bigDecimal.stripTrailingZeros().scale());
    }
}
