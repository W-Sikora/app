package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.wsikora.successbudget.v3.budget.domain.PlannedExpenditure;

import java.util.List;
import java.util.Optional;


@Repository
interface PlannedExpenditureRepository extends JpaRepository<PlannedExpenditure, Long> {

    @Query(
        """
            select e
            from PlannedExpenditure e
            where e.plannedExpenditureId = ?1
            and e.owner.value = ?#{principal.username}
        """
    )
    Optional<PlannedExpenditure> findByPlannedExpenditureId(Long plannedExpenditureId);

    @Query(
        value = """
            select e
            from PlannedExpenditure e
            where e.owner.value = ?#{principal.username}
            order by e.plannedExpenditureId
        """,
        countQuery = """
            select count(e)
            from PlannedExpenditure e
            where e.owner.value = ?#{principal.username}
        """
    )
    Page<PlannedExpenditure> findAll(Pageable pageable);

    @Query(
        """
            select e
            from PlannedExpenditure e
            where e.budget.budgetId = ?1
            and e.repeatInNextPeriod
            and e.owner.value = ?#{principal.username}
        """
    )
    List<PlannedExpenditure> findAllRepeated(Long budgetId);

    @Query(
        """
            select count(e) > 0
            from PlannedExpenditure e
            where e.budget.budgetId = ?1
            and e.repeatInNextPeriod
            and e.owner.value = ?#{principal.username}
        """
    )
    boolean hasRepeatableByBudgetId(Long budgetId);

    @Transactional
    @Modifying
    @Query(
        """
            delete
            from PlannedExpenditure e
            where e.plannedExpenditureId = ?1
            and e.owner.value = ?#{principal.username}
        """
    )
    void delete(Long plannedExpenditureId);

}
