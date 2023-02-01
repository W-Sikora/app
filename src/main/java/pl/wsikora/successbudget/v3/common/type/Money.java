package pl.wsikora.successbudget.v3.common.type;

import java.math.BigDecimal;


public class Money {

    private Currency currency;
    private BigDecimal bigDecimal;

    public Money(Currency currency, BigDecimal bigDecimal) {

        this.currency = currency;
        this.bigDecimal = bigDecimal;
    }
}
