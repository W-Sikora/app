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
import pl.wsikora.successbudget.v3.budget.domain.PlannedRevenue;
import pl.wsikora.successbudget.v3.common.type.money.Money;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;


@Repository
interface PlannedRevenueRepository extends JpaRepository<PlannedRevenue, Long> {

    @Query(
        """
            select r
            from PlannedRevenue r
            where r.plannedRevenueId = ?1
            and r.owner.value = ?#{principal.username}
        """
    )
    Optional<PlannedRevenue> findByPlannedRevenueId(Long plannedRevenueId);

    @Query(
        value = """
            select r
            from PlannedRevenue r
            where r.period = :period
            and (:categoryId is null or r.categoryId.value = :categoryId)
            and r.owner.value = ?#{principal.username}
            order by r.money.value desc
        """,
        countQuery = """
            select count(r)
            from PlannedRevenue r
            where r.period = :period
            and (:categoryId is null or r.categoryId.value = :categoryId)
            and r.owner.value = ?#{principal.username}
        """
    )
    Page<PlannedRevenue> findAll(Pageable pageable,
                                 @Param("period") YearMonth period,
                                 @Nullable @Param("categoryId") Long categoryId);

    @Query(
        """
            select r
            from PlannedRevenue r
            where r.period = ?1
            and r.repeatInNextPeriod
            and r.owner.value = ?#{principal.username}
        """
    )
    List<PlannedRevenue> findRepeatable(YearMonth period);

    @Query("""
        select new pl.wsikora.successbudget.v3.common.type.money.Money(
            r.money.currency,
            sum(r.money.value)
        )
        from PlannedRevenue r
        where r.period = ?1
        and r.owner.value = ?#{principal.username}
        group by r.money.currency
    """)
    List<Money> findAllMoney(YearMonth period);

    @Query(
        """
            select count(r) > 0
            from PlannedRevenue r
            where r.period = ?1
            and r.categoryId.value = ?2
            and r.owner.value = ?#{principal.username}
        """
    )
    boolean hasAssignedCategory(YearMonth period, Long categoryId);

    @Transactional
    @Modifying
    @Query("""
        delete
        from PlannedRevenue r
        where r.plannedRevenueId = ?1
        and r.owner.value = ?#{principal.username}
    """)
    void delete(Long plannedRevenueId);

}
