package pl.wsikora.successbudget.v3.common.type.payer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;


@Embeddable
@NoArgsConstructor
@Getter
public class Payer {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 70;

    @Column(name = "payer", length = MAXIMUM_LENGTH)
    private String value;

    private Payer(String value) {

        this.value = value;
    }

    public static Payer of(String value) {

        Assert.hasText(value, "payer value must not be empty");
        Assert.isTrue(hasValidLength(value), "payer value must be of valid length");

        return new Payer(value);
    }

    public static boolean hasValidLength(String value) {

        int length = value.length();

        return length >= MINIMUM_LENGTH && length <= MAXIMUM_LENGTH;
    }

    public static Object[] getLengthRange() {

        return new Object[]{MINIMUM_LENGTH, MAXIMUM_LENGTH};
    }

}
