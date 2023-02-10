package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.money.MoneyForm;
import pl.wsikora.successbudget.v3.common.util.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.type.money.MoneyFormValidator;

import static java.util.Objects.isNull;


@Service
class PlannedRevenueFormValidator extends AbstractFormValidator<PlannedRevenueForm> {

    static final String F_CATEGORY_ID = "categoryId";

    private final MoneyFormValidator moneyValidator;

    PlannedRevenueFormValidator(MoneyFormValidator moneyValidator) {

        this.moneyValidator = moneyValidator;
    }

    @Override
    public void validateForm(PlannedRevenueForm plannedRevenueForm, Errors errors) {

        if (isNull(plannedRevenueForm.getCategoryId())) {

            errors.rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
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
