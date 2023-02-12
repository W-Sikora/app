package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import org.springframework.data.domain.Page;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetFilter;

import java.util.Optional;


public interface PlannedRevenueQuery {

    Optional<PlannedRevenueDto> findByPlannedRevenueId(Long plannedRevenueId);

    Page<PlannedRevenueDto> findAll(BudgetFilter budgetFilter);

    boolean hasAssignedCategory(Long budgetId, Long categoryId);

}
