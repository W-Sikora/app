package pl.wsikora.successbudget.v3.budget.ui.plannedexpenditure.edit;

import lombok.*;
import pl.wsikora.successbudget.v3.budget.application.plannedexpenditure.PlannedExpenditureAttributes;

import java.math.BigDecimal;
import java.time.YearMonth;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
class PlannedExpenditureForm implements PlannedExpenditureAttributes {

    private Long plannedExpenditureId;
    private YearMonth period;
    private Long categoryId;
    private Integer priority;
    private Integer currency;
    private BigDecimal value;
    private boolean repeatInNextPeriod;

}
