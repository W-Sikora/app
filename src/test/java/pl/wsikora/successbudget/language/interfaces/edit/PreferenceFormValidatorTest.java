package pl.wsikora.successbudget.language.interfaces.edit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.language.interfaces.edit.LanguageForm.*;
import static pl.wsikora.successbudget.language.interfaces.edit.LanguageFormValidator.*;


class PreferenceFormValidatorTest {

    private LanguageFormValidator validator;
    private LanguageForm form;
    @Mock
    private Errors errors;

    @BeforeEach
    void setUp() {

        openMocks(this);

        validator = new LanguageFormValidator();

        form = new LanguageForm();
        form.setName(randomAlphabetic(F_NAME_MAX_LENGTH));
        form.setCode(randomAlphabetic(F_CODE_MAX_LENGTH));
    }

    @Test
    void shouldDetectNullName() {

        // given
        form.setName(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_NAME, E_NAME_IS_EMPTY);
    }

    @Test
    void shouldDetectEmptyName() {

        // given
        form.setName("");

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_NAME, E_NAME_IS_EMPTY);
    }

    @Test
    void shouldDetectTooLongName() {

        // given
        form.setName(randomAlphabetic(F_NAME_MAX_LENGTH + 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_NAME, E_NAME_IS_TOO_LONG);
    }

    @Test
    void shouldDetectNullCode() {

        // given
        form.setCode(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_CODE, E_CODE_IS_EMPTY);
    }

    @Test
    void shouldDetectEmptyCode() {

        // given
        form.setCode("");

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_CODE, E_CODE_IS_EMPTY);
    }

    @Test
    void shouldDetectTooLongCode() {

        // given
        form.setCode(randomAlphabetic(F_CODE_MAX_LENGTH + 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_CODE, E_CODE_IS_TOO_LONG);
    }
}
