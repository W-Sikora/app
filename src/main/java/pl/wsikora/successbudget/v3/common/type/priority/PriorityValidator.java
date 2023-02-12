package pl.wsikora.successbudget.v3.common.type.priority;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.isNull;


@Service
public class PriorityValidator extends AbstractFormValidator<Integer> {

    static final String F_PRIORITY = "priority";

    @Override
    public void validateForm(Integer priority, Errors errors) {

        if (isNull(priority)) {

            errors.rejectValue(F_PRIORITY, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!Priority.hasValidOrdinalRange(priority)) {

            errors.rejectValue(F_PRIORITY, E_FIELD_MUST_CONTAIN_VALID_VALUE);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(Integer.class);
    }

}
