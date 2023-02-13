package pl.wsikora.successbudget.v3.common.type.description;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import static org.springframework.util.StringUtils.hasText;


@Embeddable
@NoArgsConstructor
@Getter
public class Description {

    static final int MINIMUM_LENGTH = 3;
    static final int MAXIMUM_LENGTH = 255;

    @Column(name = "description")
    private String value;

    private Description(String value) {

        this.value = value;
    }
    
    public static Description of(String value) {

        Assert.isTrue(hasText(value), "description value must not be empty");
        Assert.isTrue(hasValidLength(value), "description value must be of valid length");
        
        return Description.of(value);
    }

    static boolean hasValidLength(String value) {

        int length = value.length();

        return length >= MINIMUM_LENGTH && length <= MAXIMUM_LENGTH;
    }

    static Object[] getLengthRange() {

        return new Object[]{MINIMUM_LENGTH, MAXIMUM_LENGTH};
    }

}
