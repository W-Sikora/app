package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.category.CategoryDto;
import pl.wsikora.successbudget.v3.common.type.money.MoneyDto;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;

import java.io.Serializable;


@Value
public class PlannedRevenueDto implements Serializable {

    Long plannedRevenueId;
    Long budgetId;
    CategoryDto categoryDto;
    MoneyDto moneyDto;
    boolean repeatInNextPeriod;
    UrlDto urlDto;

}
