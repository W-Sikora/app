package pl.wsikora.successbudget.common.type;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import static pl.wsikora.successbudget.common.CommonMessage.getNotEmptyMessage;

@Embeddable
public class TransactionTitle {

    private String value;

    public TransactionTitle(String value) {

        Assert.hasText(value, getNotEmptyMessage("Value of TransactionTitle"));

        this.value = value;
    }

    public TransactionTitle() {

    }
}
