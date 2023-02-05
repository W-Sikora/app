package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.application.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.application.PriorityDto;


@Value
public class PlannedExpenditureDto {

    Long plannedExpenditureId;
    Long budgetId;
    String categoryTitle;
    PriorityDto priorityDto;
    MoneyDto moneyDto;
    Integer scheduleId;

}
