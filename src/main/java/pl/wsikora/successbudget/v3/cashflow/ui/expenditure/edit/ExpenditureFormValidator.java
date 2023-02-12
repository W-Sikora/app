package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.money.MoneyForm;
import pl.wsikora.successbudget.v3.common.type.money.MoneyFormValidator;
import pl.wsikora.successbudget.v3.common.type.priority.PriorityValidator;
import pl.wsikora.successbudget.v3.common.type.title.TitleValidator;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.isNull;


@Service
class ExpenditureFormValidator extends AbstractFormValidator<ExpenditureForm> {

    static final String F_CATEGORY_ID = "categoryId";

    private final TitleValidator titleValidator;
    private final MoneyFormValidator moneyValidator;
    private final PriorityValidator priorityValidator;

    ExpenditureFormValidator(TitleValidator titleValidator,
                             MoneyFormValidator moneyValidator,
                             PriorityValidator priorityValidator) {

        this.titleValidator = titleValidator;
        this.moneyValidator = moneyValidator;
        this.priorityValidator = priorityValidator;
    }

    @Override
    public void validateForm(ExpenditureForm expenditureForm, Errors errors) {

        titleValidator.validateForm(expenditureForm.getTitle(), errors);

        Long categoryId = expenditureForm.getCategoryId();

        if (isNull(categoryId)) {

            errors.rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }

        priorityValidator.validateForm(expenditureForm.getPriority(), errors);

        MoneyForm moneyForm = new MoneyForm(
            expenditureForm.getCurrency(),
            expenditureForm.getValue()
        );

        moneyValidator.validateForm(moneyForm, errors);
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(ExpenditureForm.class);
    }

}
