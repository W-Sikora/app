package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import pl.wsikora.successbudget.v3.common.type.Username;


public interface PlannedExpenditureCommand {

    void save(PlannedExpenditureAttributes plannedExpenditureAttributes, Username username);

    void delete(Long plannedExpenditureId);

}
