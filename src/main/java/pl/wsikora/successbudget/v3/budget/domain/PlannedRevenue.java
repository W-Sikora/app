package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.Money;
import pl.wsikora.successbudget.v3.common.type.Schedule;
import pl.wsikora.successbudget.v3.common.type.Username;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "planned_revenues")
public class PlannedRevenue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long plannedRevenueId;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Embedded
    private Username owner;

    @Embedded
    private CategoryId categoryId;

    @Embedded
    private Money money;

    @Enumerated(EnumType.ORDINAL)
    private Schedule schedule;

}
