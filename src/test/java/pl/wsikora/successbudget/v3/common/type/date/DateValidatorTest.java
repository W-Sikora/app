package pl.wsikora.successbudget.v3.common.type.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.type.date.DateValidator.E_DATE_MUST_HAVE_FORMAT;
import static pl.wsikora.successbudget.v3.common.type.date.DateValidator.F_DATE;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;


class DateValidatorTest {

    @Mock
    private Errors errors;
    private DateValidator dateValidator;
    private String value;

    @BeforeEach
    void setUp() {

        openMocks(this);

        dateValidator = new DateValidator();
    }

    @Test
    void shouldDetectNullDate() {

        // given
        value = null;

        // when
        dateValidator.validateForm(value, errors);

        // then
        verify(errors).rejectValue(F_DATE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectEmptyDate() {

        // given
        value = EMPTY;

        // when
        dateValidator.validateForm(value, errors);

        // then
        verify(errors).rejectValue(F_DATE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectBlankDate() {

        // given
        value = SPACE;

        // when
        dateValidator.validateForm(value, errors);

        // then
        verify(errors).rejectValue(F_DATE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectIncompleteDate() {

        // given
        value = "2023-02";

        // when
        dateValidator.validateForm(value, errors);

        // then
        verify(errors).rejectValue(F_DATE, E_DATE_MUST_HAVE_FORMAT);
    }

    @Test
    void shouldDetectDateOfInvalidFormat() {

        // given
        value = "02/02/2023";

        // when
        dateValidator.validateForm(value, errors);

        // then
        verify(errors).rejectValue(F_DATE, E_DATE_MUST_HAVE_FORMAT);
    }

}
