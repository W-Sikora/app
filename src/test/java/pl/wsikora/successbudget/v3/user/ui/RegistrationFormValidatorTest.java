package pl.wsikora.successbudget.v3.user.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.user.domain.Password;
import pl.wsikora.successbudget.v3.user.ui.edit.registration.RegistrationForm;
import pl.wsikora.successbudget.v3.user.ui.edit.registration.RegistrationFormValidator;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator.*;
import static pl.wsikora.successbudget.v3.user.ui.edit.registration.RegistrationForm.*;


class RegistrationFormValidatorTest {

    @Mock
    private Errors errors;
    private RegistrationForm form;
    private RegistrationFormValidator validator;

    @BeforeEach
    void setUp() {

        openMocks(this);

        String password = randomAlphabetic(Password.MAXIMUM_LENGTH);

        form = RegistrationForm.builder()
            .username(randomAlphabetic(Username.MAXIMUM_LENGTH))
            .password(password)
            .repeatedPassword(password)
            .build();

        validator = new RegistrationFormValidator();
    }

    @Test
    void shouldDetectNullUsername() {

        // given
        form.setUsername(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectEmptyUsername() {

        // given
        form.setUsername(EMPTY);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectBlankTitle() {

        // given
        form.setUsername(SPACE);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortTitle() {

        // given
        form.setUsername(randomAlphabetic(Username.MINIMUM_LENGTH - 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Title.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongUsername() {

        // given
        form.setUsername(randomAlphabetic(Username.MAXIMUM_LENGTH + 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Title.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectNullPassword() {

        // given
        form.setPassword(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectEmptyPassword() {

        // given
        form.setPassword(EMPTY);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectBlankPassword() {

        // given
        form.setPassword(SPACE);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortPassword() {

        // given
        form.setPassword(randomAlphabetic(Password.MINIMUM_LENGTH - 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Title.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongPassword() {

        // given
        form.setPassword(randomAlphabetic(Password.MAXIMUM_LENGTH + 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Title.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectDifferentPassword() {

        // given
        form.setRepeatedPassword(randomAlphabetic(Password.MAXIMUM_LENGTH));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_REPEATED_PASSWORD, E_REPEATED_PASSWORD_IS_DIFFERENT);
    }
}
