package pl.wsikora.successbudget.v3.settlement.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import static org.springframework.util.StringUtils.hasText;


@Embeddable
@NoArgsConstructor
@Getter
public class Name {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 30;

    private String value;

    public Name(String value) {

        Assert.isTrue(hasText(value), "name value must not be empty");
        Assert.isTrue(hasValidLength(value), "name value must be of valid length");

        this.value = value;
    }

    public static boolean hasValidLength(String value) {

        int length = value.length();

        return length >= MINIMUM_LENGTH && length <= MAXIMUM_LENGTH;
    }

    public static Object[] getLengthRange() {

        return new Object[]{MINIMUM_LENGTH, MAXIMUM_LENGTH};
    }
}
