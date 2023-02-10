package pl.wsikora.successbudget.v3.user.ui.majorcurrency;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.validation.AbstractFormValidator;

import static java.util.Objects.isNull;


@Service
class MajorCurrencyFormValidator extends AbstractFormValidator<MajorCurrencyForm> {

    static final String F_MAJOR_CURRENCY_ID = "majorCurrencyId";

    @Override
    public void validateForm(MajorCurrencyForm majorCurrencyForm, Errors errors) {

        if (isNull(majorCurrencyForm.getMajorCurrencyId())) {

            errors.rejectValue(F_MAJOR_CURRENCY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(MajorCurrencyForm.class);
    }

}
