package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.form.MoneyForm;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.validation.MoneyValidator;

import static java.util.Objects.isNull;


@Service
class PlannedExpenditureFormValidator extends AbstractFormValidator<PlannedExpenditureForm> {

    static final String F_CATEGORY_ID = "categoryId";
    static final String F_PRIORITY_ID = "priorityId";

    private final MoneyValidator moneyValidator;

    PlannedExpenditureFormValidator(MoneyValidator moneyValidator) {

        this.moneyValidator = moneyValidator;
    }

    @Override
    public void validateForm(PlannedExpenditureForm plannedExpenditureForm, Errors errors) {

        if (isNull(plannedExpenditureForm.getCategoryId())) {

            errors.rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }

        if (isNull(plannedExpenditureForm.getPriorityId())) {

            errors.rejectValue(F_PRIORITY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }

        MoneyForm moneyForm = new MoneyForm(
            plannedExpenditureForm.getCurrencyId(),
            plannedExpenditureForm.getValue()
        );

        moneyValidator.validateForm(moneyForm, errors);

    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(PlannedExpenditureForm.class);
    }

}
