package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.common.type.priority.Priority;
import pl.wsikora.successbudget.v3.common.type.username.Username;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "planned_expenditures")
public class PlannedExpenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plannedExpenditureId;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Embedded
    private Username owner;

    @Embedded
    private CategoryId categoryId;

    @Embedded
    private Priority priority;

    @Embedded
    private Money money;

    private boolean repeatInNextPeriod;

}
