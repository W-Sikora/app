package pl.wsikora.successbudget.user.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.user.common.UserLimitation.*;
import static pl.wsikora.successbudget.user.interfaces.RegistrationForm.*;
import static pl.wsikora.successbudget.user.interfaces.RegistrationFormValidator.*;


class RegistrationFormValidatorTest {

    private RegistrationFormValidator validator;
    private RegistrationForm form;
    @Mock
    private Errors errors;

    @BeforeEach
    void setUp() {

        openMocks(this);

        validator = new RegistrationFormValidator();

        form = new RegistrationForm();

        form.setUserName(randomAlphabetic(USER_NAME_MIN_LENGTH));

        form.setEmail(randomAlphabetic(EMAIL_MIN_LENGTH));

        String password = randomAlphabetic(PASSWORD_MIN_LENGTH);

        form.setPassword(password);

        form.setRepeatedPassword(password);
    }

    @Test
    void shouldDetectNullUserName() {

        // given
        form.setUserName(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_USER_NAME,
                E_USER_NAME_INVALID,
                new Integer[] { USER_NAME_MIN_LENGTH, USER_NAME_MAX_LENGTH },
                null
        );
    }

    @Test
    void shouldDetectEmptyUserName() {

        // given
        form.setUserName("");

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_USER_NAME,
                E_USER_NAME_INVALID,
                new Integer[] { USER_NAME_MIN_LENGTH, USER_NAME_MAX_LENGTH },
                null
        );
    }

    @Test
    void shouldDetectTooLongUserName() {

        // given
        form.setUserName(randomAlphabetic(USER_NAME_MAX_LENGTH + 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_USER_NAME,
                E_USER_NAME_INVALID,
                new Integer[] { USER_NAME_MIN_LENGTH, USER_NAME_MAX_LENGTH },
                null
        );
    }

    @Test
    void shouldDetectNullEmail() {

        // given
        form.setEmail(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_EMAIL,
                E_EMAIL_INVALID,
                new Integer[] { EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH },
                null
        );    }

    @Test
    void shouldDetectEmptyEmail() {

        // given
        form.setEmail("");

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_EMAIL,
                E_EMAIL_INVALID,
                new Integer[] { EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH },
                null
        );    }

    @Test
    void shouldDetectTooShortEmail() {

        // given
        form.setEmail(randomAlphabetic(EMAIL_MIN_LENGTH - 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_EMAIL,
                E_EMAIL_INVALID,
                new Integer[] { EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH },
                null
        );
    }

    @Test
    void shouldDetectTooLongEmail() {

        // given
        form.setEmail(randomAlphabetic(EMAIL_MAX_LENGTH + 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_EMAIL,
                E_EMAIL_INVALID,
                new Integer[] { EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH },
                null
        );
    }

    @Test
    void shouldDetectNullPassword() {

        // given
        form.setPassword(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_PASSWORD,
                E_PASSWORD_INVALID,
                new Integer[] { PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH },
                null
        );    }

    @Test
    void shouldDetectEmptyPassword() {

        // given
        form.setPassword("");

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_PASSWORD,
                E_PASSWORD_INVALID,
                new Integer[] { PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH },
                null
        );    }

    @Test
    void shouldDetectTooShortPassword() {

        // given
        String password = randomAlphabetic(PASSWORD_MIN_LENGTH - 1);
        form.setPassword(password);
        form.setRepeatedPassword(password);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_PASSWORD,
                E_PASSWORD_INVALID,
                new Integer[] { PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH },
                null
        );
    }

    @Test
    void shouldDetectTooLongPassword() {

        // given
        String password = randomAlphabetic(PASSWORD_MAX_LENGTH + 1);
        form.setPassword(password);
        form.setRepeatedPassword(password);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(
                F_PASSWORD,
                E_PASSWORD_INVALID,
                new Integer[] { PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH },
                null
        );
    }

    @Test
    void shouldDetectDifferentPassword() {

        // given
        form.setRepeatedPassword(randomAlphabetic(PASSWORD_MAX_LENGTH));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_REPEATED_PASSWORD, E_REPEATED_PASSWORD_INVALID);
    }
}
