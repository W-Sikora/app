package pl.wsikora.successbudget.v3.common.type.title;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.util.StringUtils.hasText;


@Service
public class TitleValidator extends AbstractFormValidator<String> {

    static final String F_TITLE = "title";

    protected TitleValidator() {

        super(String.class);
    }

    @Override
    public void validateForm(String title, Errors errors) {

        if (!hasText(title)) {

            errors.rejectValue(F_TITLE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!Title.hasValidLength(title)) {

            errors.rejectValue(F_TITLE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Title.getLengthRange(), EMPTY);
        }
    }

}
