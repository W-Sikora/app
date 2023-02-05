package pl.wsikora.successbudget.v3.budget.ui.budget.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;

import static java.util.Objects.isNull;
import static pl.wsikora.successbudget.v3.budget.ui.budget.edit.BudgetForm.F_YEAR_MONTH;


@Service
class BudgetFormValidator extends AbstractFormValidator<BudgetForm> {


    @Override
    public void validateForm(BudgetForm budgetForm, Errors errors) {

        if (isNull(budgetForm.getYearMonth())) {

            errors.rejectValue(F_YEAR_MONTH, E_FIELD_MUST_NOT_BE_EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(BudgetForm.class);
    }
}
