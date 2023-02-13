package pl.wsikora.successbudget.v3.common.type.payer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.type.payer.Payer.MAXIMUM_LENGTH;
import static pl.wsikora.successbudget.v3.common.type.payer.Payer.MINIMUM_LENGTH;
import static pl.wsikora.successbudget.v3.common.type.payer.PayerValidator.F_PAYER;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;


class PayerValidatorTest {

    @Mock
    private Errors errors;
    private PayerValidator payerValidator;
    private String payer;

    @BeforeEach
    void setUp() {

        openMocks(this);

        payerValidator = new PayerValidator();
    }
    
    @Test
    void shouldDetectBlankPayer() {

        // given
        payer = SPACE;

        // when
        payerValidator.validateForm(payer, errors);

        // then
        verify(errors).rejectValue(F_PAYER, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortPayer() {

        // given
        payer = randomAlphabetic(MINIMUM_LENGTH - 1);

        // when
        payerValidator.validateForm(payer, errors);

        // then
        verify(errors).rejectValue(F_PAYER, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Payer.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongPayer() {

        // given
        payer = randomAlphabetic(MAXIMUM_LENGTH + 1);

        // when
        payerValidator.validateForm(payer, errors);

        // then
        verify(errors).rejectValue(F_PAYER, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Payer.getLengthRange(), EMPTY);
    }

}
