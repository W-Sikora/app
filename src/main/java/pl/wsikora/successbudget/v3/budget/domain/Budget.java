package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.util.List;


@Entity
@Table(name = "budgets")
@Getter
@Setter
@NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long budgetId;

    @Embedded
    private Username owner;

    @OneToMany
    List<PlannedRevenue> plannedRevenues;

    @OneToMany
    List<PlannedExpenditure> plannedExpenditures;

}
