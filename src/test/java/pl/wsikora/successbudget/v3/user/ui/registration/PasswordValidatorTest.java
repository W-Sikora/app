package pl.wsikora.successbudget.v3.user.ui.registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.user.domain.Password;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;
import static pl.wsikora.successbudget.v3.user.domain.Password.MAXIMUM_LENGTH;
import static pl.wsikora.successbudget.v3.user.domain.Password.MINIMUM_LENGTH;
import static pl.wsikora.successbudget.v3.user.ui.registration.PasswordValidator.F_PASSWORD;


class PasswordValidatorTest {

    @Mock
    private Errors errors;
    private PasswordValidator validator;
    private String password;

    @BeforeEach
    void setUp() {

        openMocks(this);

        validator = new PasswordValidator();
    }

    @Test
    void shouldDetectNullPassword() {

        // given
        password = null;

        // when
        validator.validateForm(password, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectEmptyPassword() {

        // given
        password = EMPTY;

        // when
        validator.validateForm(password, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectBlankPassword() {

        // given
        password = SPACE;

        // when
        validator.validateForm(password, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortPassword() {

        // given
        password = randomAlphabetic(MINIMUM_LENGTH - 1);

        // when
        validator.validateForm(password, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Password.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongPassword() {

        // given
        password = randomAlphabetic(MAXIMUM_LENGTH + 1);

        // when
        validator.validateForm(password, errors);

        // then
        verify(errors).rejectValue(F_PASSWORD, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Password.getLengthRange(), EMPTY);
    }

}
