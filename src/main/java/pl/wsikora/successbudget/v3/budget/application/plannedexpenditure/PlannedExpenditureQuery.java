package pl.wsikora.successbudget.v3.budget.application.plannedexpenditure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface PlannedExpenditureQuery {

    Optional<PlannedExpenditureDto> findByPlannedExpenditureId(Long plannedExpenditureId);

    Page<PlannedExpenditureDto> findAll(Pageable pageable);

    boolean hasRepeatable(Long budgetId);

}
