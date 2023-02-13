package pl.wsikora.successbudget.v3.common.type.date;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static org.springframework.util.StringUtils.hasText;


@Service
public class DateValidator extends AbstractFormValidator<String> {

    static final String F_DATE = "date";
    static final String E_DATE_MUST_HAVE_FORMAT = "date.must.have.format";

    DateValidator() {

        super(String.class);
    }

    @Override
    public void validateForm(String date, Errors errors) {

        if (!hasText(date)) {

            errors.rejectValue(F_DATE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!Date.hasValidFormat(date)) {

            errors.rejectValue(F_DATE, E_DATE_MUST_HAVE_FORMAT);
        }
    }

}
