package pl.wsikora.successbudget.v3.common.type.money;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.currency.CurrencyValidator;

import java.math.BigDecimal;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.type.money.MoneyFormValidator.F_VALUE;
import static pl.wsikora.successbudget.v3.common.util.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;
import static pl.wsikora.successbudget.v3.common.util.validation.AbstractFormValidator.E_VALUE_MUST_BE_WITHIN_ALLOWED_RANGE;


class MoneyFormValidatorTest {

    @Mock
    private Errors errors;
    @Mock
    private CurrencyValidator currencyValidator;
    private MoneyFormValidator moneyFormValidator;
    private MoneyForm moneyForm;

    @BeforeEach
    void setUp() {

        openMocks(this);

        moneyFormValidator = new MoneyFormValidator(currencyValidator);

        moneyForm = MoneyForm.builder()
            .currencyId(0)
            .value(BigDecimal.ZERO)
            .build();
    }

    @Test
    void shouldDetectNullValue() {

        // given
        moneyForm.setValue(null);

        // when
        moneyFormValidator.validateForm(moneyForm, errors);

        // then
        verify(errors).rejectValue(F_VALUE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooLowValue() {

        // given
        BigDecimal value = Money.MINIMUM_VALUE.subtract(BigDecimal.ONE);

        moneyForm.setValue(value);

        // when
        moneyFormValidator.validateForm(moneyForm, errors);

        // then
        verify(errors).rejectValue(F_VALUE, E_VALUE_MUST_BE_WITHIN_ALLOWED_RANGE,
            Money.getRange(), EMPTY);
    }

    @Test
    void shouldDetectTooHighValue() {

        // given
        BigDecimal value = Money.MAXIMUM_VALUE.add(BigDecimal.ONE);

        moneyForm.setValue(value);

        // when
        moneyFormValidator.validateForm(moneyForm, errors);

        // then
        verify(errors).rejectValue(F_VALUE, E_VALUE_MUST_BE_WITHIN_ALLOWED_RANGE,
            Money.getRange(), EMPTY);
    }

}
