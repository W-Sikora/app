package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.form.MoneyForm;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.validation.MoneyValidator;

import static java.util.Objects.isNull;


@Service
class PlannedRevenueFormValidator extends AbstractFormValidator<PlannedRevenueForm> {

    static final String F_CATEGORY_ID = "categoryId";

    private final MoneyValidator moneyValidator;

    PlannedRevenueFormValidator(MoneyValidator moneyValidator) {

        this.moneyValidator = moneyValidator;
    }

    @Override
    public void validateForm(PlannedRevenueForm plannedRevenueForm, Errors errors) {

        if (isNull(plannedRevenueForm.getCategoryId())) {

            errors.rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }

        MoneyForm moneyForm = new MoneyForm(
            plannedRevenueForm.getCurrencyId(),
            plannedRevenueForm.getValue()
        );

        moneyValidator.validateForm(moneyForm, errors);

    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(PlannedRevenueForm.class);
    }

}
