package pl.wsikora.successbudget.abstractutil.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

    public static final String D_VALUE = "value";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long value;

    protected AbstractEntity(long value) {

        this.value = value;
    }

    protected AbstractEntity() {

    }

    public long getValue() {

        return value;
    }
}
