package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.wsikora.successbudget.v3.budget.domain.PlannedExpenditure;
import pl.wsikora.successbudget.v3.common.type.money.Money;

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
            where e.budget.budgetId = :budgetId
            and (:categoryId is null or e.categoryId.value = :categoryId)
            and e.owner.value = ?#{principal.username}
            order by e.money.value desc, e.priority desc
        """,
        countQuery = """
            select count(e)
            from PlannedExpenditure e
            where e.budget.budgetId = :budgetId
            and (:categoryId is null or e.categoryId.value = :categoryId)
            and e.owner.value = ?#{principal.username}
        """
    )
    Page<PlannedExpenditure> findAll(Pageable pageable,
                                     @Param("budgetId") Long budgetId,
                                     @Nullable @Param("categoryId") Long categoryId);

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

    @Query(
        """
            select new pl.wsikora.successbudget.v3.common.type.money.Money(
                e.money.currency,
                sum(e.money.value)
            )
            from PlannedExpenditure e
            where e.budget.budgetId = ?1
            and e.owner.value = ?#{principal.username}
            group by e.money.currency
        """
    )
    List<Money> findAllMoney(Long budgetId);

    @Query(
        """
            select count(e) > 0
            from PlannedExpenditure e
            where e.budget.budgetId = ?1
            and e.categoryId.value = ?2
            and e.owner.value = ?#{principal.username}
        """
    )
    boolean hasAssignedCategory(Long budgetId, Long categoryId);

    @Transactional
    @Modifying
    @Query(
        """
            delete
            from PlannedExpenditure e
            where e.budget.budgetId = ?1
            and e.plannedExpenditureId = ?2
            and e.owner.value = ?#{principal.username}
        """
    )
    void delete(Long budgetId, Long plannedExpenditureId);

}
