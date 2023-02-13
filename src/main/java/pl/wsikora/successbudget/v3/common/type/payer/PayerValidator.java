package pl.wsikora.successbudget.v3.common.type.payer;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.util.StringUtils.hasText;


@Service
public class PayerValidator extends AbstractFormValidator<String> {

    static final String F_PAYER = "payer";

    protected PayerValidator() {

        super(String.class);
    }

    @Override
    public void validateForm(String payer, Errors errors) {

        if (nonNull(payer) && hasText(payer)) {

            errors.rejectValue(F_PAYER, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (nonNull(payer) && Payer.hasValidLength(payer)) {

            errors.rejectValue(F_PAYER, E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS,
                Payer.getLengthRange(), EMPTY);
        }
    }

}
