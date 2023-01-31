package pl.wsikora.successbudget.v3.category.ui.edit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.Description;
import pl.wsikora.successbudget.v3.common.type.Title;
import pl.wsikora.successbudget.v3.common.type.TransactionType;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;
import static pl.wsikora.successbudget.v3.category.ui.edit.CategoryForm.*;
import static pl.wsikora.successbudget.v3.category.ui.edit.CategoryFormValidator.E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS;
import static pl.wsikora.successbudget.v3.category.ui.edit.CategoryFormValidator.E_FIELD_MUST_NOT_BE_EMPTY;


class CategoryFormValidatorTest {

    @Mock
    private Errors errors;
    private CategoryForm form;
    private CategoryFormValidator validator;

    @BeforeEach
    void setUp() {

        openMocks(this);

        form = CategoryForm.builder()
            .title(randomAlphabetic(Title.MAXIMUM_LENGTH))
            .description(randomAlphabetic(Description.MAXIMUM_LENGTH))
            .assignedTransactionType(TransactionType.EXPENDITURE.toString())
            .build();

        validator = new CategoryFormValidator();
    }

    @Test
    void shouldDetectNullTitle() {

        // given
        form.setTitle(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectEmptyTitle() {

        // given
        form.setTitle(EMPTY);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectBlankTitle() {

        // given
        form.setTitle(SPACE);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortTitle() {

        // given
        form.setTitle(randomAlphabetic(Title.MINIMUM_LENGTH - 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Title.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongTitle() {

        // given
        form.setTitle(randomAlphabetic(Title.MINIMUM_LENGTH + 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_TITLE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Title.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectNullDescription() {

        // given
        form.setDescription(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_DESCRIPTION, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectEmptyDescription() {

        // given
        form.setDescription(EMPTY);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_DESCRIPTION, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectBlankDescription() {

        // given
        form.setDescription(SPACE);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_DESCRIPTION, E_FIELD_MUST_NOT_BE_EMPTY);
    }

    @Test
    void shouldDetectTooShortDescription() {

        // given
        form.setDescription(randomAlphabetic(Description.MINIMUM_LENGTH - 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_DESCRIPTION, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Description.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectTooLongDescription() {

        // given
        form.setDescription(randomAlphabetic(Description.MINIMUM_LENGTH + 1));

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_DESCRIPTION, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
            Description.getLengthRange(), EMPTY);
    }

    @Test
    void shouldDetectNullAssignedTransactionType() {

        // given
        form.setAssignedTransactionType(null);

        // when
        validator.validateForm(form, errors);

        // then
        verify(errors).rejectValue(F_ASSIGNED_TRANSACTION_TYPE, E_FIELD_MUST_NOT_BE_EMPTY);
    }
}
