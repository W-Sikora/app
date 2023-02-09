package pl.wsikora.successbudget.v3.common.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.Description;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.util.StringUtils.hasText;


@Service
public class DescriptionValidator extends AbstractFormValidator<String> {

    static final String F_DESCRIPTION = "description";

    @Override
    public void validateForm(String description, Errors errors) {

        if (nonNull(description) && hasText(description)) {

            errors.rejectValue(F_DESCRIPTION, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (nonNull(description) && Description.hasValidLength(description)) {

            errors.rejectValue(F_DESCRIPTION, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Description.getLengthRange(), EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(String.class);
    }

}
