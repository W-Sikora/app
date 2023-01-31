package pl.wsikora.successbudget.v3.user.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import static org.springframework.util.StringUtils.hasText;


@Embeddable
@NoArgsConstructor
@Getter
public class Password {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 60;

    private String value;

    public Password(String value) {

        Assert.isTrue(hasText(value), "password value must not be empty");
        Assert.isTrue(hasValidLength(value), "password value must be of valid length");

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
