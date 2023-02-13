package pl.wsikora.successbudget.v3.common.dashboard.aggregateexpenditure;

import lombok.Value;

import java.util.List;

@Value
public class AggregateExpendituresDto {

    List<ExpenditureWithCategoryDto> expenditureWithCategoryDtoList;
    List<ExpenditureWithPlannedExpenditureDto> expenditureWithPlannedExpenditureDtoList;
    List<ExpenditureWithPlannedExpenditurePriorityDto> expenditureWithPlannedExpenditurePriorityList;

}
