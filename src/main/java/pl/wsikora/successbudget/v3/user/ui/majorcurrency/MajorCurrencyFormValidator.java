package pl.wsikora.successbudget.v3.user.ui.majorcurrency;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.currency.CurrencyValidator;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;


@Service
class MajorCurrencyFormValidator extends AbstractFormValidator<MajorCurrencyForm> {

    private final CurrencyValidator currencyValidator;

    MajorCurrencyFormValidator(CurrencyValidator currencyValidator) {

        super(MajorCurrencyForm.class);

        this.currencyValidator = currencyValidator;
    }

    @Override
    public void validateForm(MajorCurrencyForm majorCurrencyForm, Errors errors) {

        currencyValidator.validateForm(majorCurrencyForm.getCurrency(), errors);
    }

}
