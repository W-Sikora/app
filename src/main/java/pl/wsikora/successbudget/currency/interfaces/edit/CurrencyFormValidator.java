package pl.wsikora.successbudget.currency.interfaces.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractFormValidator;

import static org.springframework.util.StringUtils.hasText;
import static pl.wsikora.successbudget.currency.interfaces.edit.CurrencyForm.*;

@Service
class CurrencyFormValidator extends AbstractFormValidator<CurrencyForm> {

    static final String E_NAME_IS_EMPTY = "validation.languageForm.name.is.empty";
    static final String E_NAME_IS_TOO_LONG = "validation.languageForm.name.is.too.long";
    static final String E_CODE_IS_EMPTY = "validation.languageForm.code.is.empty";
    static final String E_CODE_IS_TOO_LONG = "validation.languageForm.code.is.too.long";
    static final String E_SYMBOL_IS_EMPTY = "validation.languageForm.code.is.empty";
    static final String E_SYMBOL_IS_TOO_LONG = "validation.languageForm.code.is.too.long";

    @Override
    public void validateForm(CurrencyForm form, Errors errors) {

        if (!hasText(form.getName())) {

            errors.rejectValue(F_NAME, E_NAME_IS_EMPTY);
        }
        else if (form.getName().length() > F_NAME_MAX_LENGTH) {

            errors.rejectValue(F_NAME, E_NAME_IS_TOO_LONG);
        }

        if (!hasText(form.getCode())) {

            errors.rejectValue(F_CODE, E_CODE_IS_EMPTY);
        }
        else if (form.getCode().length() > F_CODE_MAX_LENGTH) {

            errors.rejectValue(F_CODE, E_CODE_IS_TOO_LONG);
        }

        if (!hasText(form.getSymbol())) {

            errors.rejectValue(F_SYMBOL, E_SYMBOL_IS_EMPTY);
        }
        else if (form.getSymbol().length() > F_SYMBOL_MAX_LENGTH) {

            errors.rejectValue(F_SYMBOL, E_SYMBOL_IS_TOO_LONG);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(CurrencyForm.class);
    }
}
