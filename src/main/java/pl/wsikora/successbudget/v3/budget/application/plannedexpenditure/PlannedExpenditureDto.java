package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;


@Value
public class PlannedExpenditureDto {

    Long plannedExpenditureId;
    Long budgetId;
    CategoryDto categoryDto;
    Integer priorityId;
    MoneyDto moneyDto;
    boolean repeatInNextPeriod;

}
