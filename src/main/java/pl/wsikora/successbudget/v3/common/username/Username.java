package pl.wsikora.successbudget.v3.common.username;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.io.Serializable;

import static org.springframework.util.StringUtils.hasText;


@Embeddable
@NoArgsConstructor
@Getter
public class Username implements Serializable {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 30;

    @Column(name = "username", length = MAXIMUM_LENGTH)
    private String value;

    public Username(String value) {

        Assert.isTrue(hasText(value), "username value must not be empty");
        Assert.isTrue(hasValidLength(value), "username value must be of valid length");

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
