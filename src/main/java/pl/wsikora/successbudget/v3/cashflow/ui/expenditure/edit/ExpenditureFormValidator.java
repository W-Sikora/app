package pl.wsikora.successbudget.v3.cashflow.ui.expenditure.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.date.DateValidator;
import pl.wsikora.successbudget.v3.common.type.money.MoneyForm;
import pl.wsikora.successbudget.v3.common.type.money.MoneyFormValidator;
import pl.wsikora.successbudget.v3.common.type.priority.PriorityValidator;
import pl.wsikora.successbudget.v3.common.type.title.TitleValidator;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.isNull;


@Service
class ExpenditureFormValidator extends AbstractFormValidator<ExpenditureForm> {

    private final TitleValidator titleValidator;
    private final MoneyFormValidator moneyValidator;
    private final PriorityValidator priorityValidator;
    private final DateValidator dateValidator;

    ExpenditureFormValidator(
        TitleValidator titleValidator,
        MoneyFormValidator moneyValidator,
        PriorityValidator priorityValidator,
        DateValidator dateValidator
    ) {

        super(ExpenditureForm.class);

        this.titleValidator = titleValidator;
        this.moneyValidator = moneyValidator;
        this.priorityValidator = priorityValidator;
        this.dateValidator = dateValidator;
    }

    @Override
    public void validateForm(ExpenditureForm expenditureForm, Errors errors) {

        titleValidator.validateForm(expenditureForm.getTitle(), errors);

        if (isNull(expenditureForm.getCategoryId())) {

            errors.rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }

        priorityValidator.validateForm(expenditureForm.getPriority(), errors);

        dateValidator.validateForm(expenditureForm.getDate(), errors);

        MoneyForm moneyForm = new MoneyForm(expenditureForm.getCurrency(), expenditureForm.getValue());

        moneyValidator.validateForm(moneyForm, errors);
    }

}
