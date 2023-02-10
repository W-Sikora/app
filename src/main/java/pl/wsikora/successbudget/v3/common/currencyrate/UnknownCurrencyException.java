package pl.wsikora.successbudget.v3.common.currencyrate;

class UnknownCurrencyException extends IllegalArgumentException {

    private static final String MESSAGE = "There is no such currency";

    UnknownCurrencyException() {

        super(MESSAGE);
    }

}
