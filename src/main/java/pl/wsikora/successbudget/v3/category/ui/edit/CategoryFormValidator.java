package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.validation.TitleValidator;

import java.util.Objects;

import static pl.wsikora.successbudget.v3.category.ui.edit.CategoryForm.F_ASSIGNED_TRANSACTION_TYPE;


@Service
class CategoryFormValidator extends AbstractFormValidator<CategoryForm> {

    private final TitleValidator titleValidator;

    CategoryFormValidator(TitleValidator titleValidator) {

        this.titleValidator = titleValidator;
    }

    @Override
    public void validateForm(CategoryForm categoryForm, Errors errors) {

        titleValidator.validateForm(categoryForm.getTitle(), errors);

        if (Objects.isNull(categoryForm.getAssignedTransactionType())) {

            errors.rejectValue(F_ASSIGNED_TRANSACTION_TYPE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(CategoryForm.class);
    }

}
