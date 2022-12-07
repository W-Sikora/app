package pl.wsikora.successbudget.preference.interfaces.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractFormValidator;

import static pl.wsikora.successbudget.preference.interfaces.edit.PreferenceForm.*;

@Service
class PreferenceFormValidator extends AbstractFormValidator<PreferenceForm> {

    static final String E_NAME_IS_EMPTY = "validation.languageForm.name.is.empty";
    static final String E_NAME_IS_TOO_LONG = "validation.languageForm.name.is.too.long";
    static final String E_CODE_IS_EMPTY = "validation.languageForm.code.is.empty";
    static final String E_CODE_IS_TOO_LONG = "validation.languageForm.code.is.too.long";

    @Override
    public void validateForm(PreferenceForm form, Errors errors) {

        if (form.getUserId() == null) {

            errors.rejectValue(F_USER_ID, "");
        }

        if (form.getLanguageId() == null) {

            errors.rejectValue(F_LANGUAGE_ID, "");
        }

        if (form.getMainCurrencyId() == null) {

            errors.rejectValue(F_MAIN_CURRENCY_ID, "");
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return PreferenceForm.class.isAssignableFrom(clazz);
    }
}
