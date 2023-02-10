package pl.wsikora.successbudget.v3.common.type.title;

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
public class Title {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 40;

    @Column(name = "title", length = MAXIMUM_LENGTH)
    private String value;

    public Title(String value) {

        Assert.isTrue(hasText(value), "title value must not be empty");
        Assert.isTrue(hasValidLength(value), "title value must be of valid length");

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
        if (!(o instanceof Title title)) return false;

        return Objects.equals(value, title.value);
    }

    @Override
    public int hashCode() {

        return value != null ? value.hashCode() : 0;
    }

}
