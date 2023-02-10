package pl.wsikora.successbudget.v3.common.type.transactiontype;

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
public class TransactionType {

    public static final TransactionType EXPENDITURE = new TransactionType(0);
    public static final TransactionType REVENUE = new TransactionType(1);

    public static final int MAXIMUM_VALUE = 1;

    @Column(name = "transaction_type")
    private Integer value;

    public TransactionType(Integer value) {

        Assert.notNull(value, "TransactionType value must not be null");
        Assert.isTrue(hasValidValueRange(value), "TransactionType value must be of valid value");

        this.value = value;
    }

    public static boolean hasValidValueRange(Integer value) {

        Assert.notNull(value, "TransactionType value must not be null");

        return value >= 0 && value <= MAXIMUM_VALUE;
    }

    public static List<Integer> getOrdinals() {

        return IntStream.range(0, MAXIMUM_VALUE + 1)
            .boxed()
            .toList();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof TransactionType that)) return false;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return value != null ? value.hashCode() : 0;
    }

}
