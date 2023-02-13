package pl.wsikora.successbudget.v3.common.type.payee;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import static org.springframework.util.StringUtils.hasText;


@Embeddable
@NoArgsConstructor
@Getter
public class Payee {

    static final int MINIMUM_LENGTH = 3;
    static final int MAXIMUM_LENGTH = 70;

    @Column(name = "payee", length = MAXIMUM_LENGTH)
    private String value;

    private Payee(String value) {

        this.value = value;
    }

    public static Payee of(String value) {

        Assert.isTrue(hasText(value), "payee value must not be empty");
        Assert.isTrue(hasValidLength(value), "payee value must be of valid length");

        return new Payee(value);
    }

    static boolean hasValidLength(String value) {

        int length = value.length();

        return length >= MINIMUM_LENGTH && length <= MAXIMUM_LENGTH;
    }

    static Object[] getLengthRange() {

        return new Object[]{MINIMUM_LENGTH, MAXIMUM_LENGTH};
    }

}
