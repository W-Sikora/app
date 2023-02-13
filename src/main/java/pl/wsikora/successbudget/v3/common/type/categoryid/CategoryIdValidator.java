package pl.wsikora.successbudget.v3.common.type.categoryid;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.isNull;


@Service
public class CategoryIdValidator extends AbstractFormValidator<Long> {

    protected CategoryIdValidator() {

        super(Long.class);
    }

    @Override
    public void validateForm(Long value, Errors errors) {

        if (isNull(value)) {

            errors.rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }
    }

}
