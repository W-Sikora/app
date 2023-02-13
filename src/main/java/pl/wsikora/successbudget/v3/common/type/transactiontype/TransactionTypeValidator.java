package pl.wsikora.successbudget.v3.common.type.transactiontype;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import pl.wsikora.successbudget.v3.common.util.ui.validation.AbstractFormValidator;

import static java.util.Objects.isNull;


@Service
public class TransactionTypeValidator extends AbstractFormValidator<Integer> {

    static final String F_TRANSACTION_TYPE = "transactionType";

    protected TransactionTypeValidator() {

        super(Integer.class);
    }

    @Override
    public void validateForm(Integer transactionType, Errors errors) {

        if (isNull(transactionType)) {

            errors.rejectValue(F_TRANSACTION_TYPE, E_FIELD_MUST_NOT_BE_EMPTY);
        }
        else if (!TransactionType.hasValidOrdinalRange(transactionType)) {

            errors.rejectValue(F_TRANSACTION_TYPE, E_FIELD_MUST_CONTAIN_VALID_VALUE);
        }
    }

}
