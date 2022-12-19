package pl.wsikora.successbudget.common.type;

import jakarta.persistence.Embeddable;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;


@Embeddable
public class BudgetId extends AbstractEntity {

    public BudgetId(long value) {

        super(value);
    }

    public BudgetId() {

    }
}
