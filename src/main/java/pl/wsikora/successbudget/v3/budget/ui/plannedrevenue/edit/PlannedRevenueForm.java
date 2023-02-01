package pl.wsikora.successbudget.v3.budget.ui.plannedrevenue.edit;

import lombok.Getter;
import lombok.Setter;
import pl.wsikora.successbudget.v3.common.type.Money;
import pl.wsikora.successbudget.v3.common.type.Schedule;

import java.time.YearMonth;


@Getter
@Setter
public class PlannedRevenueForm {

    private Long plannedRevenueId;
    private Long budgetId;
    private String title;
    private String description;
    private Long categoryId;
    private Money money;
    private Schedule schedule;
    private YearMonth yearMonth;

}
