package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.type.Description;
import pl.wsikora.successbudget.v3.common.type.Title;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static pl.wsikora.successbudget.v3.category.ui.edit.CategoryForm.*;


@Service
class CategoryFormValidator extends AbstractFormValidator<CategoryForm> {

    @Override
    public void validateForm(CategoryForm form, Errors errors) {

        String title = form.getTitle();

        if (StringUtils.hasText(title)) {

            errors.rejectValue(F_TITLE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (Title.hasValidLength(title)) {

            errors.rejectValue(F_TITLE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Title.getLengthRange(), EMPTY);
        }

        String description = form.getDescription();

        if (Objects.nonNull(description) && StringUtils.hasText(description)) {

            errors.rejectValue(F_DESCRIPTION, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (Objects.nonNull(description) && Description.hasValidLength(description)) {

            errors.rejectValue(F_DESCRIPTION, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Description.getLengthRange(), EMPTY);
        }

        if (Objects.isNull(form.getAssignedTransactionType())) {

            errors.rejectValue(F_ASSIGNED_TRANSACTION_TYPE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(CategoryForm.class);
    }
}
