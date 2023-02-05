package pl.wsikora.successbudget.v3.common.validation;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.Title;

import static org.apache.commons.lang3.StringUtils.EMPTY;


@Service
public class TitleValidator extends AbstractFormValidator<String> {

    static final String F_TITLE = "title";

    @Override
    public void validateForm(String title, Errors errors) {

        if (!StringUtils.hasText(title)) {

            errors.rejectValue(F_TITLE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!Title.hasValidLength(title)) {

            errors.rejectValue(F_TITLE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Title.getLengthRange(), EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(String.class);
    }
}
