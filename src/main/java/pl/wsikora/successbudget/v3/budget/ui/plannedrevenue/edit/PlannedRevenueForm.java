package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import lombok.Getter;
import lombok.Setter;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueAttributes;

import java.math.BigDecimal;


@Getter
@Setter
class PlannedRevenueForm implements PlannedRevenueAttributes {

    private Long plannedRevenueId;
    private Long budgetId;
    private Long categoryId;
    private Integer currencyId;
    private BigDecimal value;
    private Integer scheduleId;

}
