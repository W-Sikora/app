package pl.wsikora.successbudget.v3.common.type.date;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static pl.wsikora.successbudget.v3.common.util.DateFormatter.DATE_FORMATTER;


@Embeddable
@NoArgsConstructor
@Getter
public class Date {

    private LocalDate date;

    private Date(String value) {

        this.date = LocalDate.parse(value);
    }

    public static Date of(String value) {

        Assert.hasText(value, "date value must not be empty");
        Assert.isTrue(hasValidFormat(value), "date value must be in valid format");

        return new Date(value);
    }

    public String asString() {

        return date.format(DATE_FORMATTER);
    }

    static boolean hasValidFormat(String value) {

        try {

            LocalDate.parse(value);

            return true;
        }
        catch (DateTimeParseException exception) {

            return false;
        }
    }

}
