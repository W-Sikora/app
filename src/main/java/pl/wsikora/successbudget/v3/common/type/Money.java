package pl.wsikora.successbudget.v3.common.type;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.util.Assert;

import java.math.BigDecimal;


public class Money {

    public static final BigDecimal MINIMUM_VALUE = BigDecimal.ZERO;
    public static final BigDecimal MAXIMUM_VALUE = new BigDecimal("100000000");

    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(name = "value")

    private BigDecimal value;

    public Money(Currency currency, BigDecimal value) {

        Assert.isTrue(!isValueNegative(value), "");
        Assert.isTrue(hasValidValue(value), "");

        this.currency = currency;
        this.value = value;
    }

    public static boolean hasValidValue(BigDecimal value) {

        return true;
    }

    public static boolean isValueNegative(BigDecimal value) {

        return value.signum() < 0;
    }
}
