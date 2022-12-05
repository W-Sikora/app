package pl.wsikora.successbudget.budget.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import pl.wsikora.successbudget.abstractutil.domain.AbstractEntity;


@Entity
@Table(name = "budgets")
public class Budget extends AbstractEntity {

    private String name;

    private Long userCreatorId;

}
