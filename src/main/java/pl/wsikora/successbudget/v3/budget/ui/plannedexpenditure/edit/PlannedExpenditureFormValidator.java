package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureQuery;
import pl.wsikora.successbudget.v3.common.type.categoryid.CategoryIdValidator;
import pl.wsikora.successbudget.v3.common.type.money.MoneyForm;
import pl.wsikora.successbudget.v3.common.type.money.MoneyFormValidator;
import pl.wsikora.successbudget.v3.common.type.priority.PriorityValidator;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


@Service
class PlannedExpenditureFormValidator extends AbstractFormValidator<PlannedExpenditureForm> {

    private final CategoryIdValidator categoryIdValidator;
    private final PlannedExpenditureQuery plannedExpenditureQuery;
    private final MoneyFormValidator moneyValidator;
    private final PriorityValidator priorityValidator;

    PlannedExpenditureFormValidator(
        CategoryIdValidator categoryIdValidator,
        PlannedExpenditureQuery plannedExpenditureQuery,
        MoneyFormValidator moneyValidator,
        PriorityValidator priorityValidator
    ) {

        super(PlannedExpenditureForm.class);

        this.categoryIdValidator = categoryIdValidator;
        this.plannedExpenditureQuery = plannedExpenditureQuery;
        this.moneyValidator = moneyValidator;
        this.priorityValidator = priorityValidator;
    }

    @Override
    public void validateForm(PlannedExpenditureForm plannedExpenditureForm, Errors errors) {

        Long categoryId = plannedExpenditureForm.getCategoryId();

        categoryIdValidator.validateForm(categoryId, errors);

        if (isNull(plannedExpenditureForm.getPlannedExpenditureId())
            && nonNull(categoryId)
            && plannedExpenditureQuery.hasAssignedCategory(plannedExpenditureForm.getPeriod(), categoryId)) {

            errors.rejectValue(F_CATEGORY_ID, E_HAS_ASSIGNED_CATEGORY);
        }

        priorityValidator.validateForm(plannedExpenditureForm.getPriority(), errors);

        MoneyForm moneyForm = new MoneyForm(plannedExpenditureForm.getCurrency(), plannedExpenditureForm.getValue());

        moneyValidator.validateForm(moneyForm, errors);
    }

}
