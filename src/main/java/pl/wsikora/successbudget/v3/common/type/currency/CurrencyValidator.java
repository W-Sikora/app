package pl.wsikora.successbudget.v3.common.type.currency;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.isNull;


@Service
public class CurrencyValidator extends AbstractFormValidator<Integer> {

    static final String F_CURRENCY = "currency";

    @Override
    public void validateForm(Integer currency, Errors errors) {

        if (isNull(currency)) {

            errors.rejectValue(F_CURRENCY, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!Currency.hasValidOrdinalRange(currency)) {

            errors.rejectValue(F_CURRENCY, E_FIELD_MUST_CONTAIN_VALID_VALUE);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(Integer.class);
    }

}
