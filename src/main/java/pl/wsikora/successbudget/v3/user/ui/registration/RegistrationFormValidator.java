package pl.wsikora.successbudget.v3.user.ui.registration;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;

import java.util.Objects;


@Service
class RegistrationFormValidator extends AbstractFormValidator<RegistrationForm> {

    private final UsernameValidator usernameValidator;
    private final PasswordValidator passwordValidator;

    RegistrationFormValidator(UsernameValidator usernameValidator, PasswordValidator passwordValidator) {

        this.usernameValidator = usernameValidator;
        this.passwordValidator = passwordValidator;
    }

    @Override
    public void validateForm(RegistrationForm registrationForm, Errors errors) {

        usernameValidator.validateForm(registrationForm.getUsername(), errors);

        String password = registrationForm.getPassword();

        passwordValidator.validateForm(password, errors);

        if (!Objects.equals(password, registrationForm.getRepeatedPassword())) {

            errors.rejectValue(RegistrationForm.F_REPEATED_PASSWORD, E_REPEATED_PASSWORD_IS_DIFFERENT);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(RegistrationForm.class);
    }
}
