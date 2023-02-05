package pl.wsikora.successbudget.v3.user.ui.registration;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.user.domain.Password;

import static org.apache.commons.lang3.StringUtils.EMPTY;


@Service
class PasswordValidator extends AbstractFormValidator<String> {

    @Override
    public void validateForm(String password, Errors errors) {

        if (!StringUtils.hasText(password)) {

            errors.rejectValue(RegistrationForm.F_PASSWORD, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!Password.hasValidLength(password)) {

            errors.rejectValue(RegistrationForm.F_PASSWORD, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Password.getLengthRange(), EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(String.class);
    }

}
