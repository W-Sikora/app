package pl.wsikora.successbudget.v3.budget.application.plannedrevenue;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface PlannedRevenueQuery {

    Optional<PlannedRevenueDto> findByPlannedRevenueId(Long plannedRevenueId);

    Page<PlannedRevenueDto> findAll(Pageable pageable, Long budgetId);

}
