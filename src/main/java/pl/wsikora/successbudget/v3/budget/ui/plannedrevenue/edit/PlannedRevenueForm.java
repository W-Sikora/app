package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import lombok.*;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueAttributes;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
class PlannedRevenueForm implements PlannedRevenueAttributes {

    private Long plannedRevenueId;
    private Long budgetId;
    private Long categoryId;
    private Integer currencyId;
    private BigDecimal value;
    private boolean repeatInNextPeriod;

}
