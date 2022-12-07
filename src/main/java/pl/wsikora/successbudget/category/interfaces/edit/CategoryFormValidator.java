package pl.wsikora.successbudget.category.interfaces.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractFormValidator;

@Service
class CategoryFormValidator extends AbstractFormValidator<CategoryForm> {

    @Override
    public void validateForm(CategoryForm categoryForm, Errors errors) {

    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(CategoryForm.class);
    }
}
