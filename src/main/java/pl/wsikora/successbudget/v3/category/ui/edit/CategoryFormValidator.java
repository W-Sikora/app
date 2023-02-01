package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.validation.DescriptionValidator;
import pl.wsikora.successbudget.v3.common.validation.TitleValidator;

import java.util.Objects;

import static pl.wsikora.successbudget.v3.category.ui.edit.CategoryForm.F_ASSIGNED_TRANSACTION_TYPE;


@Service
class CategoryFormValidator extends AbstractFormValidator<CategoryForm> {

    private final TitleValidator titleValidator;
    private final DescriptionValidator descriptionValidator;

    CategoryFormValidator(TitleValidator titleValidator,
                          DescriptionValidator descriptionValidator) {

        this.titleValidator = titleValidator;
        this.descriptionValidator = descriptionValidator;
    }

    @Override
    public void validateForm(CategoryForm form, Errors errors) {

        titleValidator.validateForm(form.getTitle(), errors);

        descriptionValidator.validateForm(form.getDescription(), errors);

        if (Objects.isNull(form.getAssignedTransactionType())) {

            errors.rejectValue(F_ASSIGNED_TRANSACTION_TYPE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(CategoryForm.class);
    }
}
