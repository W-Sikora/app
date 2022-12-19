package pl.wsikora.successbudget.common.type;

import jakarta.persistence.Embeddable;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;

@Embeddable
public class CurrencyId extends AbstractEntity {

    public CurrencyId(long value) {

        super(value);
    }

    public CurrencyId() {

    }
}
