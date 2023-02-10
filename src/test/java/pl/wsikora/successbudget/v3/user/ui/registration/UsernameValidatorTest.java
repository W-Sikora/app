package pl.wsikora.successbudget.v3.user.ui.registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.user.application.UserQuery;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.util.validation.AbstractFormValidator.E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS;
import static pl.wsikora.successbudget.v3.common.util.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;
import static pl.wsikora.successbudget.v3.user.ui.registration.UsernameValidator.E_USERNAME_MUST_BE_UNIQUE;
import static pl.wsikora.successbudget.v3.user.ui.registration.UsernameValidator.F_USER_NAME;


class UsernameValidatorTest {

    @Mock
    private Errors errors;
    @Mock
    private UserQuery userQuery;
    private UsernameValidator usernameValidator;
    private String username;

    @BeforeEach
    void setUp() {

        openMocks(this);

        usernameValidator = new UsernameValidator(userQuery);
    }

    @Test
    void shouldDetectNullUsername() {

        // given
        username = null;

        // when
        usernameValidator.validateForm(username, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectEmptyUsername() {

        // given
        username = EMPTY;

        // when
        usernameValidator.validateForm(username, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectBlankUsername() {

        // given
        username = SPACE;

        // when
        usernameValidator.validateForm(username, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortUsername() {

        // given
        username = randomAlphabetic(Username.MINIMUM_LENGTH - 1);

        // when
        usernameValidator.validateForm(username, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Username.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongUsername() {

        // given
        username = randomAlphabetic(Username.MAXIMUM_LENGTH + 1);

        // when
        usernameValidator.validateForm(username, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Username.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectNotUniqueUsername() {

        // given
        username = randomAlphabetic(Username.MAXIMUM_LENGTH + 1);

        given(userQuery.existsByUsername(new Username(username)))
            .willReturn(true);

        // when
        usernameValidator.validateForm(this.username, errors);

        // then
        verify(errors).rejectValue(F_USER_NAME, E_USERNAME_MUST_BE_UNIQUE);
    }

}
