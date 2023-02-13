package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import pl.wsikora.successbudget.v3.common.type.repeat.RepeatCommand;


public interface PlannedRevenueCommand {

    void save(PlannedRevenueAttributes plannedRevenueAttributes);

    void delete(Long plannedRevenueId);

    void repeat(RepeatCommand repeatCommand);

}
