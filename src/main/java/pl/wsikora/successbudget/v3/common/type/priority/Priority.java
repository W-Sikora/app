package pl.wsikora.successbudget.v3.common.type.priority;

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
public class Priority {

    public static final Priority UNNECESSARY = new Priority(0);
    public static final Priority LOW = new Priority(1);
    public static final Priority NORMAL = new Priority(2);
    public static final Priority HIGH = new Priority(3);
    public static final Priority CRITICAL = new Priority(4);

    public static final int MAXIMUM_VALUE = 4;

    @Column(name = "priority")
    private Integer value;

    public Priority(Integer value) {

        Assert.notNull(value, "Priority value must not be null");
        Assert.isTrue(hasValidValueRange(value), "Priority value must be of valid value");

        this.value = value;
    }

    public static boolean hasValidValueRange(Integer value) {

        Assert.notNull(value, "Priority value must not be null");

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
        if (!(o instanceof Priority priority)) return false;

        return Objects.equals(value, priority.value);
    }

    @Override
    public int hashCode() {

        return value != null ? value.hashCode() : 0;
    }

}
