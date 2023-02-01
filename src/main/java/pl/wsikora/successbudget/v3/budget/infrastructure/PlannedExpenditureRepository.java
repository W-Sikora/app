package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.successbudget.v3.budget.domain.PlannedExpenditure;


public interface PlannedExpenditureRepository extends JpaRepository<PlannedExpenditure, Long> {

}
