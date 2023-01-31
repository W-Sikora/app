package pl.wsikora.successbudget.v3.user.ui.edit.preference;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;

@Service
class PreferenceFormValidator extends AbstractFormValidator<PreferenceForm> {


    @Override
    public void validateForm(PreferenceForm form, Errors errors) {


    }

    @Override
    public boolean supports(Class<?> clazz) {

        return PreferenceForm.class.isAssignableFrom(clazz);
    }
}
