package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wsikora.successbudget.v3.budget.domain.Budget;


public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Budget getByBudgetId(Long budgetId);

    @Query("select count(b) > 0 from Budget b where b.budgetId = ?1 and b.owner.value = ?2")
    boolean existsByBudgetIdAndUsername(Long budgetId, String username);
}
