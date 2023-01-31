package pl.wsikora.successbudget.v3.common.type;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@Embeddable
public class BudgetId implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "budget_id")
    private Long value;
}
