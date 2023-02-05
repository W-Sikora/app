package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.cashflow.ui.cashflow.edit.CashFlowForm;
import pl.wsikora.successbudget.v3.common.validation.AbstractFormValidator;
import pl.wsikora.successbudget.v3.common.validation.DescriptionValidator;
import pl.wsikora.successbudget.v3.common.validation.TitleValidator;


@Service
class CashFlowFormValidator extends AbstractFormValidator<CashFlowForm> {

    private final TitleValidator titleValidator;
    private final DescriptionValidator descriptionValidator;

    CashFlowFormValidator(TitleValidator titleValidator,
                          DescriptionValidator descriptionValidator) {

        this.titleValidator = titleValidator;
        this.descriptionValidator = descriptionValidator;
    }

    @Override
    public void validateForm(CashFlowForm cashFlowForm, Errors errors) {

        titleValidator.validateForm(cashFlowForm.getTitle(), errors);

        descriptionValidator.validateForm(cashFlowForm.getDescription(), errors);
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(CashFlowForm.class);
    }
}
