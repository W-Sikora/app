package pl.wsikora.successbudget.v3.common.type.transactiontype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionTypeValidator.F_TRANSACTION_TYPE;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_CONTAIN_VALID_VALUE;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;


class TransactionTypeValidatorTest {

    @Mock
    private Errors errors;
    @Mock
    private TransactionTypeValidator transactionTypeValidator;
    private Integer transactionType;

    @BeforeEach
    void setUp() {

        openMocks(this);

        transactionTypeValidator = new TransactionTypeValidator();
    }

    @Test
    void shouldDetectNullValue() {

        // given
        transactionType = null;

        // when
        transactionTypeValidator.validateForm(transactionType, errors);

        // then
        verify(errors).rejectValue(F_TRANSACTION_TYPE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooLowValue() {

        // given
        transactionType = -1;

        // when
        transactionTypeValidator.validateForm(transactionType, errors);

        // then
        verify(errors).rejectValue(F_TRANSACTION_TYPE, E_FIELD_MUST_CONTAIN_VALID_VALUE);
    }

    @Test
    void shouldDetectTooHighValue() {

        // given
        transactionType = 1_000;

        // when
        transactionTypeValidator.validateForm(transactionType, errors);

        // then
        verify(errors).rejectValue(F_TRANSACTION_TYPE, E_FIELD_MUST_CONTAIN_VALID_VALUE);
    }

}
