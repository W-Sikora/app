package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.Money;
import pl.wsikora.successbudget.v3.common.type.Priority;
import pl.wsikora.successbudget.v3.common.type.Schedule;
import pl.wsikora.successbudget.v3.common.type.Username;


@Entity
@Table(name = "planned_expenditures")
@Getter
@Setter
@NoArgsConstructor
public class PlannedExpenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long plannedExpenditureId;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Embedded
    private Username owner;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Enumerated(EnumType.ORDINAL)
    private Priority priority;

    @Embedded
    private Money money;

    @Enumerated(EnumType.ORDINAL)
    private Schedule schedule;

}
