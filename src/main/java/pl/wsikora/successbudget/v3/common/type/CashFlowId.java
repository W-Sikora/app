package pl.wsikora.successbudget.v3.common.type;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;


@Embeddable
@NoArgsConstructor
@Getter
public class CashFlowId {

    @Column(name = "cash_flow_id")
    private Long value;

    public CashFlowId(Long value) {

        Assert.notNull(value, "CashFlowId value must not be null");

        this.value = value;
    }

}
