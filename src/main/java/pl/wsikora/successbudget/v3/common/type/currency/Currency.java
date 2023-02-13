package pl.wsikora.successbudget.v3.common.type.currency;

import lombok.Getter;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;


@Getter
public enum Currency {

    POLISH_ZLOTY("zł"),
    EURO("€"),
    UNITED_STATES_DOLLAR("$"),
    STERLING("£"),
    SWISS_FRANC("Fr");

    private final String sign;

    Currency(String sign) {

        this.sign = sign;
    }

    public static Currency of(Integer ordinal) {

        Assert.isTrue(hasValidOrdinalRange(ordinal), "Currency ordinal must be of valid value");

        return Currency.values()[ordinal];
    }

    static boolean hasValidOrdinalRange(Integer ordinal) {

        Assert.notNull(ordinal, "Currency ordinal must not be null");

        return ordinal > 0 || ordinal < Currency.values().length;
    }

    public boolean isPln() {

        return this == POLISH_ZLOTY;
    }

    public boolean isEur() {

        return this == EURO;
    }

    public boolean isUsd() {

        return this == UNITED_STATES_DOLLAR;
    }

    public boolean isGbp() {

        return this == STERLING;
    }

    public boolean isChf() {

        return this == SWISS_FRANC;
    }

    public static List<Integer> getOrdinals() {

        return Arrays.stream(Currency.values())
            .map(Currency::ordinal)
            .toList();
    }

}
