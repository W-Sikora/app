package pl.wsikora.successbudget.currency.interfaces.edit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.currency.interfaces.edit.CurrencyForm.*;
import static pl.wsikora.successbudget.currency.interfaces.edit.CurrencyFormValidator.*;

class CurrencyFormValidatorTest {

    private CurrencyFormValidator validator;
    private CurrencyForm form;
    @Mock
    private Errors errors;

    @BeforeEach
    void setUp() {

        openMocks(this);

        validator = new CurrencyFormValidator();

        form = new CurrencyForm();
        form.setName(randomAlphabetic(F_NAME_MAX_LENGTH));
        form.setCode(randomAlphabetic(F_CODE_MAX_LENGTH));
        form.setSymbol(randomAlphabetic(F_SYMBOL_MAX_LENGTH));
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

    @Test
    void shouldDetectNullSymbol() {

        // given
        form.setSymbol(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_SYMBOL, E_SYMBOL_IS_EMPTY);
    }

    @Test
    void shouldDetectEmptySymbol() {

        // given
        form.setSymbol("");

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_SYMBOL, E_SYMBOL_IS_EMPTY);
    }

    @Test
    void shouldDetectTooLongSymbol() {

        // given
        form.setSymbol(randomAlphabetic(F_SYMBOL_MAX_LENGTH + 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_SYMBOL, E_SYMBOL_IS_TOO_LONG);
    }
}
