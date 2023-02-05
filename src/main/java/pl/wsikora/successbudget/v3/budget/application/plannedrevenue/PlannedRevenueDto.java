package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.application.MoneyDto;

import java.io.Serializable;


@Value
public class PlannedRevenueDto implements Serializable {

    Long plannedRevenueId;
    Long budgetId;
    String categoryTitle;
    MoneyDto moneyDto;
    Integer schedule;

}
