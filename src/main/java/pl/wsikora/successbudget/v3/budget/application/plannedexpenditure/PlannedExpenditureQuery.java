package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import org.springframework.data.domain.Page;
import pl.wsikora.successbudget.v3.budget.application.budget.BudgetFilter;

import java.util.Optional;


public interface PlannedExpenditureQuery {

    Optional<PlannedExpenditureDto> findByPlannedExpenditureId(Long plannedExpenditureId);

    Page<PlannedExpenditureDto> findAll(BudgetFilter budgetFilter);

    boolean hasAssignedCategory(Long budgetId, Long categoryId);

}
