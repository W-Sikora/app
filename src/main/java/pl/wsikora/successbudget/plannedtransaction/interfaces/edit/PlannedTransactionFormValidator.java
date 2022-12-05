package pl.wsikora.successbudget.plannedtransaction.interfaces.edit;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.abstractutil.interfaces.AbstractFormValidator;
import pl.wsikora.successbudget.plannedtransaction.domain.PlannedTransaction;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;
import static pl.wsikora.successbudget.common.interfaces.ValidatorUtil.isValidCurrencyValue;
import static pl.wsikora.successbudget.plannedtransaction.interfaces.edit.PlannedTransactionForm.*;

@Service
public class PlannedTransactionFormValidator extends AbstractFormValidator<PlannedTransactionForm> {

    @Override
    public void validateForm(PlannedTransactionForm form, Errors errors) {

        if (isNull(form.getBudgetId())) {

            errors.rejectValue(F_BUDGET_ID, "");
        }

        if (!hasText(form.getName())) {

            errors.rejectValue(F_NAME, "");
        }

        if (isNull(form.getTransactionTypeId())) {

            errors.rejectValue(F_TRANSACTION_TYPE_ID, "");
        }

        if (isNull(form.getCategoryId())) {

            errors.rejectValue(F_CATEGORY_ID, "");
        }

        if (isValidCurrencyValue(form.getValue())) {

            errors.rejectValue(F_VALUE, "");
        }

        if (isNull(form.getCurrencyId())) {

            errors.rejectValue(F_CURRENCY_ID, "");
        }

        if (!isValidCycleValue(form.getCycleValue())) {

            errors.rejectValue(F_CYCLE_VALUE, "");
        }

        if (isNull(form.getAccountingPeriod())) {

            errors.rejectValue(F_ACCOUNTING_PERIOD, "");
        }
    }

    private boolean isValidCycleValue(String cycleValue) {

        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(PlannedTransactionForm.class);
    }
}
