package pl.wsikora.successbudget.v3.user.ui.registration;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.user.domain.Password;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.util.StringUtils.hasText;


@Service
class PasswordValidator extends AbstractFormValidator<String> {

    static final String F_PASSWORD = "password";

    protected PasswordValidator() {

        super(String.class);
    }

    @Override
    public void validateForm(String password, Errors errors) {

        if (!hasText(password)) {

            errors.rejectValue(F_PASSWORD, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!Password.hasValidLength(password)) {

            errors.rejectValue(F_PASSWORD, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Password.getLengthRange(), EMPTY);
        }
    }

}
