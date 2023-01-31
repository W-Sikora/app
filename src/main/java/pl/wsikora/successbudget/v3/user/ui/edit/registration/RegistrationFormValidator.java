package pl.wsikora.successbudget.v3.user.ui.edit.registration;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.user.domain.Password;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static pl.wsikora.successbudget.v3.user.ui.edit.registration.RegistrationForm.*;


@Service
class RegistrationFormValidator extends AbstractFormValidator<RegistrationForm> {

    @Override
    public void validateForm(RegistrationForm registrationForm, Errors errors) {

        String userName = registrationForm.getUsername();

        if (StringUtils.hasText(userName)) {

            errors.rejectValue(F_USER_NAME, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (Username.hasValidLength(userName)) {

            errors.rejectValue(F_USER_NAME, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Username.getLengthRange(), EMPTY);
        }

        String password = registrationForm.getPassword();

        if (StringUtils.hasText(password)) {

            errors.rejectValue(F_PASSWORD, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (Password.hasValidLength(password)) {

            errors.rejectValue(F_PASSWORD, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Password.getLengthRange(), EMPTY);
        }

        if (!Objects.equals(password, registrationForm.getRepeatedPassword())) {

            errors.rejectValue(F_REPEATED_PASSWORD, E_REPEATED_PASSWORD_IS_DIFFERENT);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(RegistrationForm.class);
    }
}
