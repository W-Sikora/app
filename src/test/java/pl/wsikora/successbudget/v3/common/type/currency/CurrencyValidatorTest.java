package pl.wsikora.successbudget.v3.common.type.currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.type.currency.CurrencyValidator.F_CURRENCY;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_CONTAIN_VALID_VALUE;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;


class CurrencyValidatorTest {

    @Mock
    private Errors errors;
    @Mock
    private CurrencyValidator currencyValidator;
    private Integer currency;

    @BeforeEach
    void setUp() {

        openMocks(this);

        currencyValidator = new CurrencyValidator();
    }

    @Test
    void shouldDetectNullValue() {

        // given
        currency = null;

        // when
        currencyValidator.validateForm(currency, errors);

        // then
        verify(errors).rejectValue(F_CURRENCY, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooLowValue() {

        // given
        currency = -1;

        // when
        currencyValidator.validateForm(currency, errors);

        // then
        verify(errors).rejectValue(F_CURRENCY, E_FIELD_MUST_CONTAIN_VALID_VALUE);
    }

    @Test
    void shouldDetectTooHighValue() {

        // given
        currency = 1_000;

        // when
        currencyValidator.validateForm(currency, errors);

        // then
        verify(errors).rejectValue(F_CURRENCY, E_FIELD_MUST_CONTAIN_VALID_VALUE);
    }

}
