package pl.wsikora.successbudget.v3.budget.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.Money;

import java.time.YearMonth;


@Value
public class PlannedExpenditureDto {

    Long plannedExpenditureId;
    String title;
    String description;
    String categoryTitle;
    Money money;
    Integer scheduleId;
    YearMonth yearMonth;

}
