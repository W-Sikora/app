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
}
