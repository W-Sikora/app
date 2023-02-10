package pl.wsikora.successbudget.v3.category.ui.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.title.TitleValidator;
import pl.wsikora.successbudget.v3.common.type.transactiontype.TransactionTypeValidator;
import pl.wsikora.successbudget.v3.common.util.validation.AbstractFormValidator;


@Service
class CategoryFormValidator extends AbstractFormValidator<CategoryForm> {

    private final TitleValidator titleValidator;
    private final TransactionTypeValidator transactionTypeValidator;

    CategoryFormValidator(TitleValidator titleValidator, TransactionTypeValidator transactionTypeValidator) {

        this.titleValidator = titleValidator;
        this.transactionTypeValidator = transactionTypeValidator;
    }

    @Override
    public void validateForm(CategoryForm categoryForm, Errors errors) {

        titleValidator.validateForm(categoryForm.getTitle(), errors);

        transactionTypeValidator.validateForm(categoryForm.getTransactionType(), errors);
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(CategoryForm.class);
    }

}
