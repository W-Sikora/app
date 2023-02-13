package pl.wsikora.successbudget.v3.common.type.title;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;


@Embeddable
@NoArgsConstructor
@Getter
public class Title {

    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 40;

    @Column(name = "title", length = MAXIMUM_LENGTH)
    private String value;

    private Title(String value) {

        this.value = value;
    }

    public static Title of(String value) {

        Assert.hasText(value, "title value must not be empty");
        Assert.isTrue(hasValidLength(value), "title value must be of valid length");

        return new Title(value);
    }

    public static boolean hasValidLength(String value) {

        int length = value.length();

        return length >= MINIMUM_LENGTH && length <= MAXIMUM_LENGTH;
    }

    public static Object[] getLengthRange() {

        return new Object[]{MINIMUM_LENGTH, MAXIMUM_LENGTH};
    }

}
