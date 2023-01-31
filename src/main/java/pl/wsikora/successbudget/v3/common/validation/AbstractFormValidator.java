package pl.wsikora.successbudget.v3.common.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractFormValidator<Form> implements Validator {

    public static final String E_FIELD_MUST_NOT_BE_EMPTY = "field.must.not.be.empty";
    public static final String E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS = "field.must.contain.specific.number.of.characters";
    public static final String E_REPEATED_PASSWORD_IS_DIFFERENT = "repeated.password.is.different";


    public abstract void validateForm(Form form, Errors errors);

    public abstract boolean supports(Class<?> clazz);

    @Override
    @SuppressWarnings("unchecked")
    public void validate(Object target, Errors errors) {

        validateForm((Form) target, errors);
    }
}
