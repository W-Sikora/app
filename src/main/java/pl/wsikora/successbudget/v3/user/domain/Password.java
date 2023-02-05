package pl.wsikora.successbudget.v3.user.domain;

import jakarta.persistence.Column;
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
    public static final int MAXIMUM_LENGTH = 30;

    @Column(name = "password")
    private String value;

    private Password(String value) {

        this.value = value;
    }

    public static Password of(String value) {

        Assert.isTrue(hasText(value), "password value must not be empty");
        Assert.isTrue(hasValidLength(value), "password value must be of valid length");

        return new Password(value);
    }

    public static Password encoded(String encodedValue) {

        Assert.isTrue(hasText(encodedValue), "password encodedValue must not be empty");

        return new Password(encodedValue);
    }

    public static boolean hasValidLength(String value) {

        int length = value.length();

        return length >= MINIMUM_LENGTH && length <= MAXIMUM_LENGTH;
    }

    public static Object[] getLengthRange() {

        return new Object[]{MINIMUM_LENGTH, MAXIMUM_LENGTH};
    }

}
