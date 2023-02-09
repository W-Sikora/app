package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

public interface PlannedRevenueCommand {

    void save(PlannedRevenueAttributes plannedRevenueAttributes);

    void delete(Long plannedExpenditureId);

    void repeat(Long fromBudgetId, Long toBudgetId);

}
