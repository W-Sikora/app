package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import pl.wsikora.successbudget.v3.common.type.Username;


public interface PlannedRevenueCommand {

    void save(PlannedRevenueAttributes plannedRevenueAttributes, Username username);

    void delete(Long plannedExpenditureId);

}
