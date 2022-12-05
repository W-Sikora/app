package pl.wsikora.successbudget.language.interfaces.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractFormValidator;

import static org.springframework.util.StringUtils.hasText;
import static pl.wsikora.successbudget.language.interfaces.edit.LanguageForm.*;

@Service
class LanguageFormValidator extends AbstractFormValidator<LanguageForm> {

    static final String E_NAME_IS_EMPTY = "validation.languageForm.name.is.empty";
    static final String E_NAME_IS_TOO_LONG = "validation.languageForm.name.is.too.long";
    static final String E_CODE_IS_EMPTY = "validation.languageForm.code.is.empty";
    static final String E_CODE_IS_TOO_LONG = "validation.languageForm.code.is.too.long";

    @Override
    public void validateForm(LanguageForm languageForm, Errors errors) {

        if (!hasText(languageForm.getName())) {

            errors.rejectValue(F_NAME, E_NAME_IS_EMPTY);
        }
        else if (languageForm.getName().length() > F_NAME_MAX_LENGTH) {

            errors.rejectValue(F_NAME, E_NAME_IS_TOO_LONG);
        }

        if (!hasText(languageForm.getCode())) {

            errors.rejectValue(F_CODE, E_CODE_IS_EMPTY);
        }
        else if (languageForm.getCode().length() > F_CODE_MAX_LENGTH) {

            errors.rejectValue(F_CODE, E_CODE_IS_TOO_LONG);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(LanguageForm.class);
    }
}
