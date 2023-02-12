package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueQuery;
import pl.wsikora.successbudget.v3.common.type.money.MoneyForm;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.type.money.MoneyFormValidator;

import static java.util.Objects.isNull;


@Service
class PlannedRevenueFormValidator extends AbstractFormValidator<PlannedRevenueForm> {

    static final String F_CATEGORY_ID = "categoryId";

    private final PlannedRevenueQuery plannedRevenueQuery;
    private final MoneyFormValidator moneyValidator;

    PlannedRevenueFormValidator(PlannedRevenueQuery plannedRevenueQuery,
                                MoneyFormValidator moneyValidator) {

        this.plannedRevenueQuery = plannedRevenueQuery;
        this.moneyValidator = moneyValidator;
    }

    @Override
    public void validateForm(PlannedRevenueForm plannedRevenueForm, Errors errors) {

        Long budgetId = plannedRevenueForm.getBudgetId();

        Long categoryId = plannedRevenueForm.getCategoryId();

        if (isNull(categoryId)) {

            errors.rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (plannedRevenueQuery.hasAssignedCategory(budgetId, categoryId)) {

            errors.rejectValue(F_CATEGORY_ID, E_HAS_ASSIGNED_CATEGORY);
        }

        MoneyForm moneyForm = new MoneyForm(
            plannedRevenueForm.getCurrency(),
            plannedRevenueForm.getValue()
        );

        moneyValidator.validateForm(moneyForm, errors);

    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(PlannedRevenueForm.class);
    }

}
