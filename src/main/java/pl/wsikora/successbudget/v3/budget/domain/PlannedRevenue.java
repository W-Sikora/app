package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.category.CategoryId;
import pl.wsikora.successbudget.v3.common.money.Money;
import pl.wsikora.successbudget.v3.common.username.Username;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "planned_revenues")
public class PlannedRevenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private boolean repeatInNextPeriod;

}
