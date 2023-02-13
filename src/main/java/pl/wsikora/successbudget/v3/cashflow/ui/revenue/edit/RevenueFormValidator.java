package pl.wsikora.successbudget.v3.cashflow.ui.revenue.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.type.money.MoneyForm;
import pl.wsikora.successbudget.v3.common.type.money.MoneyFormValidator;
import pl.wsikora.successbudget.v3.common.type.title.TitleValidator;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.isNull;


@Service
class RevenueFormValidator extends AbstractFormValidator<RevenueForm> {

    private final TitleValidator titleValidator;
    private final MoneyFormValidator moneyValidator;

    RevenueFormValidator(
        TitleValidator titleValidator,
        MoneyFormValidator moneyValidator
    ) {

        super(RevenueForm.class);

        this.titleValidator = titleValidator;
        this.moneyValidator = moneyValidator;
    }

    @Override
    public void validateForm(RevenueForm revenueForm, Errors errors) {

        titleValidator.validateForm(revenueForm.getTitle(), errors);

        if (isNull(revenueForm.getCategoryId())) {

            errors.rejectValue(F_CATEGORY_ID, E_FIELD_MUST_NOT_BE_EMPTY);
        }

        MoneyForm moneyForm = new MoneyForm(revenueForm.getCurrency(), revenueForm.getValue());

        moneyValidator.validateForm(moneyForm, errors);
    }

}
