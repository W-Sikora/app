package pl.wsikora.successbudget.v3.common.type.money;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import pl.wsikora.successbudget.v3.common.type.currency.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static java.math.BigDecimal.ZERO;


@Embeddable
@NoArgsConstructor
@Getter
public class Money {

    public static final BigDecimal MINIMUM_VALUE = ZERO;
    public static final BigDecimal MAXIMUM_VALUE = new BigDecimal("1000000");
    
    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;

    @Column(name = "value")
    private BigDecimal value;

    Money(Currency currency, BigDecimal value) {

        this.currency = currency;
        this.value = value;
    }

    public static Money of(Currency currency, BigDecimal value) {

        Assert.notNull(currency, "currency must not be null");
        Assert.isTrue(hasValidValue(value), "value must be valid");

        return new Money(currency, value.setScale(SCALE, ROUNDING_MODE));
    }

    public static Money of(Currency currency) {

        Assert.notNull(currency, "currency must not be null");

        return new Money(currency, ZERO);
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

    public Money add(Money money) {

        Assert.isTrue(this.hasTheSameCurrency(money), "added money must have the same currency");

        return new Money(
            this.currency,
            this.value.add(money.value).setScale(SCALE, ROUNDING_MODE)
        );
    }

    public Money add(Money money, BigDecimal convertRate) {

        Assert.isTrue(this.hasDifferentCurrency(money), "added money must have different currencies");
        Assert.notNull(convertRate, "convertRate must not be null");

        BigDecimal convertedValue = money.value.multiply(convertRate);

        return new Money(
            this.currency,
            this.value.add(convertedValue).setScale(SCALE, ROUNDING_MODE)
        );
    }

    public Money subtract(Money money) {

        Assert.isTrue(this.hasTheSameCurrency(money), "subtracted money must have the same currency");

        return new Money(
            this.currency,
            this.value.subtract(money.value).setScale(SCALE, ROUNDING_MODE)
        );
    }

    public Money subtract(Money money, BigDecimal convertRate) {

        Assert.isTrue(this.hasDifferentCurrency(money), "subtracted money must have different currencies");
        Assert.notNull(convertRate, "convertRate must not be null");

        BigDecimal convertedValue = money.value.multiply(convertRate);

        return new Money(
            this.currency,
            this.value.subtract(convertedValue).setScale(SCALE, ROUNDING_MODE)
        );
    }

    public Money convert(Currency toCurrency, BigDecimal convertRate) {

        Assert.notNull(toCurrency, "toCurrency must not be null");
        Assert.notNull(convertRate, "convertRate must not be null");

        return new Money(
            toCurrency,
            this.value.multiply(convertRate).setScale(SCALE, ROUNDING_MODE)
        );
    }

    public boolean hasTheSameCurrency(Money money) {

        Assert.notNull(money, "money must not be null");

        return this.currency.equals(money.currency);
    }

    public boolean hasTheSameCurrency(Currency currency) {

        Assert.notNull(currency, "currency must not be null");

        return this.currency.equals(currency);
    }

    public boolean hasDifferentCurrency(Money money) {

        return !hasTheSameCurrency(money);
    }

    public boolean hasDifferentCurrency(Currency currency) {

        return !hasTheSameCurrency(currency);
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
