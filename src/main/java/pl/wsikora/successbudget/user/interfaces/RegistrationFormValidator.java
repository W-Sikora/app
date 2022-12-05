package pl.wsikora.successbudget.user.interfaces;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractFormValidator;

import java.util.Objects;

import static org.springframework.util.StringUtils.hasText;
import static pl.wsikora.successbudget.common.NumericUtil.isBeyond;
import static pl.wsikora.successbudget.user.common.UserLimitation.*;
import static pl.wsikora.successbudget.user.interfaces.RegistrationForm.*;


@Service
class RegistrationFormValidator extends AbstractFormValidator<RegistrationForm> {

    static final String E_USER_NAME_NOT_EMPTY = "userName.not.empty";
    static final String E_USER_NAME_INVALID_RANGE = "userName.invalid.range";
    static final String E_EMAIL_NOT_EMPTY = "email.not.empty";
    static final String E_EMAIL_INVALID_RANGE = "email.invalid.range";
    static final String E_PASSWORD_NOT_EMPTY ="password.not.empty";
    static final String E_PASSWORD_INVALID_RANGE ="password.invalid.range";
    static final String E_REPEATED_PASSWORD_INVALID = "repeatedPassword.invalid";

    @Override
    public void validateForm(RegistrationForm registrationForm, Errors errors) {

        String userName = registrationForm.getUserName();

        if (!hasText(userName)) {

            errors.rejectValue(F_USER_NAME, E_USER_NAME_NOT_EMPTY);

        }
        else if (isBeyond(userName.length(), USER_NAME_MIN_LENGTH, USER_NAME_MAX_LENGTH)) {

            errors.rejectValue(
                    F_USER_NAME,
                    E_USER_NAME_INVALID_RANGE,
                    new Object[] { USER_NAME_MIN_LENGTH, USER_NAME_MAX_LENGTH },
                    null
            );
        }

        String email = registrationForm.getEmail();

        if (!hasText(email)) {

            errors.rejectValue(F_EMAIL, E_EMAIL_NOT_EMPTY);
        }
        else if (isBeyond(email.length(), EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH)) {

            errors.rejectValue(
                    F_EMAIL,
                    E_EMAIL_INVALID_RANGE,
                    new Integer[] { EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH },
                    null
            );
        }

        String password = registrationForm.getPassword();

        if (!hasText(password)) {

            errors.rejectValue(F_PASSWORD, E_PASSWORD_NOT_EMPTY);
        }
        else if (isBeyond(password.length(), PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH)) {

            errors.rejectValue(
                    F_PASSWORD,
                    E_PASSWORD_INVALID_RANGE,
                    new Integer[] { PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH },
                    null
            );
        }

        if (!Objects.equals(password, registrationForm.getRepeatedPassword())) {

            errors.rejectValue(F_REPEATED_PASSWORD, E_REPEATED_PASSWORD_INVALID);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(RegistrationForm.class);
    }
}
