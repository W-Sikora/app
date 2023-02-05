package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import lombok.Getter;
import lombok.Setter;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureAttributes;

import java.math.BigDecimal;


@Getter
@Setter
class PlannedExpenditureForm implements PlannedExpenditureAttributes {

    private Long plannedExpenditureId;
    private Long budgetId;
    private Long categoryId;
    private Integer priorityId;
    private Integer currencyId;
    private BigDecimal value;
    private Integer scheduleId;

}
