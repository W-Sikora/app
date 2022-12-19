package pl.wsikora.successbudget.common.type;

import jakarta.persistence.Embeddable;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;


@Embeddable
public class UserId extends AbstractEntity {

    public UserId() {

    }

    public UserId(long value) {

        super(value);
    }
}
