package pl.wsikora.successbudget.common.type;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static java.math.BigDecimal.ZERO;
import static pl.wsikora.successbudget.common.CommonMessage.*;

@Embeddable
public class Money {

    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_DOWN;

    private BigDecimal value;
    private CurrencyId currencyId;

    public Money(BigDecimal value, CurrencyId currencyId) {

        Assert.notNull(value, getNotNullMessage("value"));
        Assert.isTrue(value.compareTo(ZERO) > 0, getNotGreaterThenZeroMessage("value"));
        Assert.notNull(currencyId, getNotNullMessage("currencyId"));

        this.value = value.setScale(SCALE, ROUNDING_MODE);
        this.currencyId = currencyId;
    }

    @Deprecated
    public Money() {

    }

    public static Money of(BigDecimal value, CurrencyId currencyId) {

        return new Money(value, currencyId);
    }

    public Money add(Money money) {

        canPerformOperation(money);

        return new Money(value.add(money.value), currencyId);
    }

    public Money sumUp(List<Money> moneys) {

        Assert.notEmpty(moneys, getNotEmptyCollectionMessage("moneys"));

        return moneys.stream()
                .reduce(new Money(ZERO, currencyId), Money::add);
    }

    public Money subtract(Money money) {

        canPerformOperation(money);

        return new Money(value.subtract(money.value), currencyId);
    }

    private void canPerformOperation(Money money) throws IllegalArgumentException {

        Assert.notNull(money, getNotNullMessage("money"));
        Assert.isTrue(this.currencyId.equals(money.currencyId), getNotIdenticalMessage("currencies"));
    }
}
