package pl.wsikora.successbudget.v3.common.validation;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.Description;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;


@Service
public class DescriptionValidator extends AbstractFormValidator<String> {

    static final String F_DESCRIPTION = "description";

    @Override
    public void validateForm(String description, Errors errors) {

        if (Objects.nonNull(description) && StringUtils.hasText(description)) {

            errors.rejectValue(F_DESCRIPTION, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (Objects.nonNull(description) && Description.hasValidLength(description)) {

            errors.rejectValue(F_DESCRIPTION, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Description.getLengthRange(), EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(String.class);
    }
}
