package pl.wsikora.successbudget.common.interfaces;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;
import static pl.wsikora.successbudget.common.NumericUtil.isBeyond;


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

    private boolean hasNoTextOrTextLengthIsBeyondRange(String text, int minLength, int maxLength) {

        return !hasText(text) || isBeyond(text.length(), minLength, maxLength);
    }
}
