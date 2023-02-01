package pl.wsikora.successbudget.v3.common.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.Title;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator.E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS;
import static pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;
import static pl.wsikora.successbudget.v3.common.validation.TitleValidator.F_TITLE;


class TitleValidatorTest {

    @Mock
    private Errors errors;
    private TitleValidator titleValidator;

    @BeforeEach
    void setUp() {

        openMocks(this);

        titleValidator = new TitleValidator();
    }

    @Test
    void shouldDetectNullTitle() {

        // given
        String title = null;

        // when
        titleValidator.validateForm(title, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectEmptyTitle() {

        // given
        String title = EMPTY;

        // when
        titleValidator.validateForm(title, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectBlankTitle() {

        // given
        String title = SPACE;

        // when
        titleValidator.validateForm(title, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortTitle() {

        // given
        String title = randomAlphabetic(Title.MINIMUM_LENGTH - 1);

        // when
        titleValidator.validateForm(title, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Title.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongTitle() {

        // given
        String title = randomAlphabetic(Title.MINIMUM_LENGTH + 1);

        // when
        titleValidator.validateForm(title, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Title.getLengthRange(), EMPTY);
    }
}
