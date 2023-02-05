package pl.wsikora.successbudget.v3.budget.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.Money;

import java.io.Serializable;
import java.time.YearMonth;


@Value
public class PlannedRevenueDto implements Serializable {

    Long plannedRevenueId;
    String title;
    String description;
    String categoryTitle;
    Money money;
    Integer schedule;
    YearMonth yearMonth;

}
