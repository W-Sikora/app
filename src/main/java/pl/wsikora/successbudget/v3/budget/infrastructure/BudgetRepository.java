package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.budget.domain.Budget;

import java.time.YearMonth;


@Repository
interface BudgetRepository extends JpaRepository<Budget, Long> {

    @Query("""
        select b
        from Budget b
        where b.budgetId = ?1
        and b.yearMonth = ?2
        and b.owner.value = ?#{principal.username}
    """)
    Budget getByBudgetIdAndYearMonth(Long budgetId, YearMonth yearMonth);

}
