package pl.wsikora.successbudget.v3.common.type.priority;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.type.priority.PriorityValidator.F_PRIORITY;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_CONTAIN_VALID_VALUE;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;


class PriorityValidatorTest {

    @Mock
    private Errors errors;
    @Mock
    private PriorityValidator priorityValidator;
    private Integer priority;

    @BeforeEach
    void setUp() {

        openMocks(this);

        priorityValidator = new PriorityValidator();
    }

    @Test
    void shouldDetectNullValue() {

        // given
        priority = null;

        // when
        priorityValidator.validateForm(priority, errors);

        // then
        verify(errors).rejectValue(F_PRIORITY, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooLowValue() {

        // given
        priority = -1;

        // when
        priorityValidator.validateForm(priority, errors);

        // then
        verify(errors).rejectValue(F_PRIORITY, E_FIELD_MUST_CONTAIN_VALID_VALUE);
    }

    @Test
    void shouldDetectTooHighValue() {

        // given
        priority = 1_000;

        // when
        priorityValidator.validateForm(priority, errors);

        // then
        verify(errors).rejectValue(F_PRIORITY, E_FIELD_MUST_CONTAIN_VALID_VALUE);
    }

}
