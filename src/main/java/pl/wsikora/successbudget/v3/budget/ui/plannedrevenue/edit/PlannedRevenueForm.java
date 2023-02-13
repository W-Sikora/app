package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import lombok.*;
import pl.wsikora.successbudget.v3.budget.application.plannedrevenue.PlannedRevenueAttributes;

import java.math.BigDecimal;
import java.time.YearMonth;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
class PlannedRevenueForm implements PlannedRevenueAttributes {

    private Long plannedRevenueId;
    private YearMonth period;
    private Long categoryId;
    private Integer currency;
    private BigDecimal value;
    private boolean repeatInNextPeriod;

}
