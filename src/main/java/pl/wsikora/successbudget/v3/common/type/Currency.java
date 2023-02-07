package pl.wsikora.successbudget.v3.common.type;

import lombok.Getter;


@Getter
public enum Currency {

    POLISH_ZLOTY("zł", "PLN"),
    EURO("€", "EUR"),
    UNITED_STATES_DOLLAR("$", "USD"),
    STERLING("£", "GBP"),
    SWISS_FRANC("Fr", "CHF");

    private final String symbol;
    private final String code;

    Currency(String symbol, String code) {

        this.symbol = symbol;
        this.code = code;
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
}
