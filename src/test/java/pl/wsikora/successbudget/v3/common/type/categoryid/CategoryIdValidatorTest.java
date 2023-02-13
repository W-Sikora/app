package pl.wsikora.successbudget.v3.common.type.categoryid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;
import static pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator.F_CATEGORY_ID;


class CategoryIdValidatorTest {

    @Mock
    private Errors errors;
    private CategoryIdValidator categoryIdValidator;

    @BeforeEach
    void setUp() {

        openMocks(this);

        categoryIdValidator = new CategoryIdValidator();
    }

    @Test
    void shouldDetectNullCategoryId() {

        // given
        Long value = null;

        // when
        categoryIdValidator.validateForm(value, errors);

        // then
        verify(errors).rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
    }

}
