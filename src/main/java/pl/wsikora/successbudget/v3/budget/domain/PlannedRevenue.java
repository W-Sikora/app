package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.Money;
import pl.wsikora.successbudget.v3.common.type.Username;

import java.time.YearMonth;


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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Embedded
    private Money money;

    private YearMonth yearMonth;

}
