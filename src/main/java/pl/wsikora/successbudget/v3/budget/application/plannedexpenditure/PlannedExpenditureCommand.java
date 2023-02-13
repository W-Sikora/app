package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import pl.wsikora.successbudget.v3.common.type.repeat.RepeatCommand;


public interface PlannedExpenditureCommand {

    void save(PlannedExpenditureAttributes plannedExpenditureAttributes);

    void delete(Long plannedExpenditureId);

    void repeat(RepeatCommand repeatCommand);

}
