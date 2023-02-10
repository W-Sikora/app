package pl.wsikora.successbudget.v3.common.type.currency;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;


@Embeddable
@NoArgsConstructor
@Getter
public class Currency {

    public static final Currency POLISH_ZLOTY = new Currency(0);
    public static final Currency EURO = new Currency(1);
    public static final Currency UNITED_STATES_DOLLAR = new Currency(2);
    public static final Currency STERLING = new Currency(3);
    public static final Currency SWISS_FRANC = new Currency(4);

    public static final int MAXIMUM_VALUE = 4;

    @Column(name = "currency")
    private Integer value;

    public Currency(Integer value) {

        Assert.notNull(value, "Currency value must not be null");
        Assert.isTrue(hasValidValueRange(value), "Currency value must be of valid value");

        this.value = value;
    }

    public static boolean hasValidValueRange(Integer value) {

        Assert.notNull(value, "Currency value must not be null");

        return value >= 0 && value <= MAXIMUM_VALUE;
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

    public static List<Integer> getOrdinals() {

        return IntStream.range(0, MAXIMUM_VALUE + 1)
            .boxed()
            .toList();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Currency currency)) return false;

        return Objects.equals(value, currency.value);
    }

    @Override
    public int hashCode() {

        return value != null ? value.hashCode() : 0;
    }

}
