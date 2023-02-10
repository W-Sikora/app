package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.money.MoneyForm;
import pl.wsikora.successbudget.v3.common.type.priority.PriorityValidator;
import pl.wsikora.successbudget.v3.common.util.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.type.money.MoneyFormValidator;

import static java.util.Objects.isNull;


@Service
class PlannedExpenditureFormValidator extends AbstractFormValidator<PlannedExpenditureForm> {

    static final String F_CATEGORY_ID = "categoryId";

    private final MoneyFormValidator moneyValidator;
    private final PriorityValidator priorityValidator;

    PlannedExpenditureFormValidator(MoneyFormValidator moneyValidator,
                                    PriorityValidator priorityValidator) {

        this.moneyValidator = moneyValidator;
        this.priorityValidator = priorityValidator;
    }

    @Override
    public void validateForm(PlannedExpenditureForm plannedExpenditureForm, Errors errors) {

        if (isNull(plannedExpenditureForm.getCategoryId())) {

            errors.rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }

        priorityValidator.validateForm(plannedExpenditureForm.getPriority(), errors);

        MoneyForm moneyForm = new MoneyForm(
            plannedExpenditureForm.getCurrency(),
            plannedExpenditureForm.getValue()
        );

        moneyValidator.validateForm(moneyForm, errors);

    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(PlannedExpenditureForm.class);
    }

}
