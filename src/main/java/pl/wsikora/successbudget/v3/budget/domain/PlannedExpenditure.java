package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "planned_expenditures")
public class PlannedExpenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long plannedExpenditureId;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Embedded
    private Username owner;

    @Embedded
    private CategoryId categoryId;

    @Enumerated(EnumType.ORDINAL)
    private Priority priority;

    @Embedded
    private Money money;

    @Enumerated(EnumType.ORDINAL)
    private Schedule schedule;

}
