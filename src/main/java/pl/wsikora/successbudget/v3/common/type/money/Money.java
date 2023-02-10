package pl.wsikora.successbudget.v3.common.type.money;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;

import java.math.BigDecimal;
import java.util.Objects;


@Embeddable
@NoArgsConstructor
@Getter
public class Money {

    public static final BigDecimal MINIMUM_VALUE = BigDecimal.ZERO;
    public static final BigDecimal MAXIMUM_VALUE = new BigDecimal("1000000");

    @Embedded
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Money money)) return false;

        if (!Objects.equals(currency, money.currency)) return false;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {

        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

}
