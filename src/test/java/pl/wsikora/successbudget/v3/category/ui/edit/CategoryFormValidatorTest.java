package pl.wsikora.successbudget.v3.category.ui.edit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.category.TransactionType;
import pl.wsikora.successbudget.v3.common.validation.TitleValidator;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.category.ui.edit.CategoryForm.F_ASSIGNED_TRANSACTION_TYPE;
import static pl.wsikora.successbudget.v3.category.ui.edit.CategoryFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;


class CategoryFormValidatorTest {

    @Mock
    private Errors errors;
    @Mock
    private TitleValidator titleValidator;
    private CategoryFormValidator validator;
    private CategoryForm categoryForm;

    @BeforeEach
    void setUp() {

        openMocks(this);

        categoryForm = CategoryForm.builder()
            .title(randomAlphabetic(Title.MAXIMUM_LENGTH))
            .assignedTransactionType(TransactionType.EXPENDITURE.ordinal())
            .build();

        validator = new CategoryFormValidator(titleValidator);
    }

    @Test
    void shouldDetectNullAssignedTransactionType() {

        // given
        categoryForm.setAssignedTransactionType(null);

        // when
        validator.validateForm(categoryForm, errors);

        // then
        verify(errors).rejectValue(F_ASSIGNED_TRANSACTION_TYPE, E_FIELD_MUST_NOT_BE_EMPTY);
    }
}
