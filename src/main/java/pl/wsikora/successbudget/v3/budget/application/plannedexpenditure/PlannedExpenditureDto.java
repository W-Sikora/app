package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;


@Value
public class PlannedExpenditureDto {

    Long plannedExpenditureId;
    Long budgetId;
    CategoryDto categoryDto;
    Integer priority;
    MoneyDto moneyDto;
    boolean repeatInNextPeriod;
    UrlDto urlDto;

}
