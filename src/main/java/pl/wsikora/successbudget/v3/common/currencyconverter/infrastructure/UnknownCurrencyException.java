package pl.wsikora.successbudget.v3.common.currencyconverter.infrastructure;

class UnknownCurrencyException extends IllegalArgumentException {

    private static final String MESSAGE = "There is no such currency";

    UnknownCurrencyException() {

        super(MESSAGE);
    }

}
