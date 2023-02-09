package pl.wsikora.successbudget.v3.common.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.form.MoneyForm;
import pl.wsikora.successbudget.v3.common.money.Money;

import java.math.BigDecimal;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;


@Service
public class MoneyValidator extends AbstractFormValidator<MoneyForm> {

    static final String F_CURRENCY_ID = "currencyId";
    static final String F_VALUE = "value";

    @Override
    public void validateForm(MoneyForm moneyForm, Errors errors) {

        if (isNull(moneyForm.getCurrencyId())) {

            errors.rejectValue(F_CURRENCY_ID, E_CURRENCY_MUST_NOT_BE_EMPTY);
        }

        BigDecimal value = moneyForm.getValue();

        if (isNull(value)) {

            errors.rejectValue(F_VALUE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (Money.hasValidValue(value)) {

            errors.rejectValue(F_VALUE, E_VALUE_MUST_BE_WITHIN_ALLOWED_RANGE,
                Money.getRange(), EMPTY);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(MoneyForm.class);
    }

}
