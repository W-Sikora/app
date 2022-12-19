package pl.wsikora.successbudget.common.type;

import jakarta.persistence.Embeddable;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;


@Embeddable
public class PlannedTransactionId extends AbstractEntity {

    public PlannedTransactionId(long value) {

        super(value);
    }

    @Deprecated
    public PlannedTransactionId() {
    }
}
