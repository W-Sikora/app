package pl.wsikora.successbudget.v3.common.type.payee;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.util.StringUtils.hasText;


@Service
public class PayeeValidator extends AbstractFormValidator<String> {

    static final String F_PAYEE = "payee";

    PayeeValidator() {

        super(String.class);
    }

    @Override
    public void validateForm(String payee, Errors errors) {

        if (nonNull(payee) && hasText(payee)) {

            errors.rejectValue(F_PAYEE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (nonNull(payee) && Payee.hasValidLength(payee)) {

            errors.rejectValue(F_PAYEE, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Payee.getLengthRange(), EMPTY);
        }
    }

}
