package pl.wsikora.successbudget.v3.user.ui.registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.user.domain.Password;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.util.validation.AbstractFormValidator.E_REPEATED_PASSWORD_IS_DIFFERENT;
import static pl.wsikora.successbudget.v3.user.ui.registration.RegistrationFormValidator.F_REPEATED_PASSWORD;


class RegistrationFormValidatorTest {

    @Mock
    private Errors errors;
    @Mock
    private UsernameValidator usernameValidator;
    @Mock
    private PasswordValidator passwordValidator;

    private RegistrationForm form;

    private RegistrationFormValidator registrationFormValidator;

    @BeforeEach
    void setUp() {

        openMocks(this);

        String random = randomAlphabetic(Password.MAXIMUM_LENGTH);

        form = new RegistrationForm();
        form.setUsername(random);
        form.setPassword(random);

        registrationFormValidator = new RegistrationFormValidator(usernameValidator, passwordValidator);
    }

    @Test
    void shouldDetectDifferentPassword() {

        // given
        form.setRepeatedPassword(randomAlphabetic(Password.MAXIMUM_LENGTH));

        // when
        registrationFormValidator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_REPEATED_PASSWORD, E_REPEATED_PASSWORD_IS_DIFFERENT);
    }

}
