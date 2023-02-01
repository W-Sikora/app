package pl.wsikora.successbudget.v3.budget.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.wsikora.successbudget.v3.category.domain.Category;
import pl.wsikora.successbudget.v3.common.type.*;

import java.time.YearMonth;


@Entity
@Table(name = "planned_revenues")
@Getter
@Setter
@NoArgsConstructor
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
    private Title title;

    @Embedded
    private Description description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Embedded
    private Money money;

    @Embedded
    private Schedule schedule;

    private YearMonth yearMonth;

}
