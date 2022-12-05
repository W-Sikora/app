package pl.wsikora.successbudget.abstractutil.interfaces;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractFormValidator<Form> implements Validator {

    public abstract void validateForm(Form form, Errors errors);

    public abstract boolean supports(Class<?> clazz);

    @Override
    @SuppressWarnings("unchecked")
    public void validate(Object target, Errors errors) {

        validateForm((Form) target, errors);
    }
}
