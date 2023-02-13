package pl.wsikora.successbudget.v3.common.util.ui.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.reflect.ParameterizedType;


public abstract class AbstractFormValidator<Form> implements Validator {

    public static final String F_PERIOD = "period";
    public static final String F_CATEGORY_ID = "categoryId";
    public static final String F_DATE = "date";
    
    public static final String E_FIELD_MUST_NOT_BE_EMPTY = "field.must.not.be.empty";
    public static final String E_FIELD_MUST_CONTAIN_SPECIFIC_NUMBER_OF_CHARACTERS = "field.must.contain.specific.number.of.characters";
    public static final String E_FIELD_MUST_CONTAIN_VALID_VALUE = "field.must.contain.valid.value";
    public static final String E_VALUE_MUST_BE_WITHIN_ALLOWED_RANGE = "value.must.be.within.allowed.range";
    public static final String E_HAS_ASSIGNED_CATEGORY = "category.is.already.assigned";

    private final Class<Form> form;

    protected AbstractFormValidator(Class<Form> form) {

        this.form = (Class<Form>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public abstract void validateForm(Form form, Errors errors);

    @Override
    public boolean supports(Class<?> clazz) {

        return form.isAssignableFrom(clazz);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void validate(Object target, Errors errors) {

        validateForm((Form) target, errors);
    }
}
