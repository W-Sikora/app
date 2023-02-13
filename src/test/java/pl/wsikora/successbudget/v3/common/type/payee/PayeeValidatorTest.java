package pl.wsikora.successbudget.v3.common.type.payee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.type.payee.Payee.MAXIMUM_LENGTH;
import static pl.wsikora.successbudget.v3.common.type.payee.Payee.MINIMUM_LENGTH;
import static pl.wsikora.successbudget.v3.common.type.payee.PayeeValidator.F_PAYEE;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;


class PayeeValidatorTest {

    @Mock
    private Errors errors;
    private PayeeValidator payeeValidator;
    private String payee;

    @BeforeEach
    void setUp() {

        openMocks(this);

        payeeValidator = new PayeeValidator();
    }
    
    @Test
    void shouldDetectBlankPayee() {

        // given
        payee = SPACE;

        // when
        payeeValidator.validateForm(payee, errors);

        // then
        verify(errors).rejectValue(F_PAYEE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortPayee() {

        // given
        payee = randomAlphabetic(MINIMUM_LENGTH - 1);

        // when
        payeeValidator.validateForm(payee, errors);

        // then
        verify(errors).rejectValue(F_PAYEE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Payee.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongPayee() {

        // given
        payee = randomAlphabetic(MAXIMUM_LENGTH + 1);

        // when
        payeeValidator.validateForm(payee, errors);

        // then
        verify(errors).rejectValue(F_PAYEE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Payee.getLengthRange(), EMPTY);
    }

}
