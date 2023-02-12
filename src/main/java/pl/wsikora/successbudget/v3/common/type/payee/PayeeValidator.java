package pl.wsikora.successbudget.v3.common.type.payee;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.util.StringUtils.hasText;


@Service
public class PayeeValidator extends AbstractFormValidator<String> {

    static final String F_PAYEE = "payee";

    @Override
    public void validateForm(String payee, Errors errors) {

        if (!hasText(payee)) {

            errors.rejectValue(F_PAYEE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!Payee.hasValidLength(payee)) {

            errors.rejectValue(F_PAYEE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Payee.getLengthRange(), EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(String.class);
    }

}
