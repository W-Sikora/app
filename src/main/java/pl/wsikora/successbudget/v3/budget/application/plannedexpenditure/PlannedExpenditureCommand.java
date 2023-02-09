package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

public interface PlannedExpenditureCommand {

    void save(PlannedExpenditureAttributes plannedExpenditureAttributes);

    void delete(Long plannedExpenditureId);

    void repeat(Long fromBudgetId, Long toBudgetId);

}
