package pl.wsikora.successbudget.v3.common.money;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.Currency;

import java.math.BigDecimal;


@Embeddable
@NoArgsConstructor
@Getter
public class Money {

    public static final BigDecimal MINIMUM_VALUE = BigDecimal.ZERO;
    public static final BigDecimal MAXIMUM_VALUE = new BigDecimal("100000000");

    @Enumerated(EnumType.ORDINAL)
    private Currency currency;

    @Column(name = "value")
    private BigDecimal value;

    public Money(Currency currency, BigDecimal value) {

        Assert.isTrue(hasValidValue(value), "value must be valid");

        this.currency = currency;
        this.value = value;
    }

    public static boolean hasValidValue(BigDecimal value) {

        return isGreaterThanOrEqualTo(value, MINIMUM_VALUE)
            && isLessThanOrEqualTo(value, MAXIMUM_VALUE);
    }

    public static boolean isGreaterThanOrEqualTo(BigDecimal value1, BigDecimal value2) {

        return value1.compareTo(value2) > -1;
    }

    public static boolean isLessThanOrEqualTo(BigDecimal value1, BigDecimal value2) {

        return value1.compareTo(value2) < 1;
    }

    public static Object[] getRange() {

        return new Object[]{MINIMUM_VALUE, MAXIMUM_VALUE};
    }
}
