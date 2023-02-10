package pl.wsikora.successbudget.v3.common.type.description;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.Objects;

import static org.springframework.util.StringUtils.hasText;


@Embeddable
@NoArgsConstructor
@Getter
public class Description {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 255;

    @Column(name = "description")
    private String value;

    public Description(String value) {

        Assert.isTrue(hasText(value), "description value must not be empty");
        Assert.isTrue(hasValidLength(value), "description value must be of valid length");

        this.value = value;
    }

    public static boolean hasValidLength(String value) {

        int length = value.length();

        return length >= MINIMUM_LENGTH && length <= MAXIMUM_LENGTH;
    }

    public static Object[] getLengthRange() {

        return new Object[]{MINIMUM_LENGTH, MAXIMUM_LENGTH};
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Description that)) return false;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return value != null ? value.hashCode() : 0;
    }

}
