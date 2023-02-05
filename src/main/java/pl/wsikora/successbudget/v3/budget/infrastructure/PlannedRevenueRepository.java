package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.successbudget.v3.budget.domain.PlannedRevenue;


public interface PlannedRevenueRepository extends JpaRepository<PlannedRevenue, Long> {



}
