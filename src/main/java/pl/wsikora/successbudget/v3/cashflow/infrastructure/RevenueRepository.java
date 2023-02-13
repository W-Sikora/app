package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import pl.wsikora.successbudget.v3.cashflow.domain.Revenue;
import pl.wsikora.successbudget.v3.common.type.money.Money;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;


interface RevenueRepository extends JpaRepository<Revenue, Long> {

    @Query("""
        select r
        from Revenue r
        where r.revenueId = ?1
        and r.owner.value = ?#{principal.username}
    """)
    Optional<Revenue> findByRevenueId(Long revenueId);

    @Query(
        value = """
            select r
            from Revenue r
            where r.period = :period
            and (:keyword is null or lower(r.title.value) like %:keyword%)
            and (:categoryId is null or r.categoryId.value = :categoryId)
            and (:fromDate is null or :toDate is null or (r.date >= :fromDate and r.date <= :toDate))
            and r.owner.value = ?#{principal.username}
            order by r.date desc, r.money.value desc
        """,
        countQuery = """
            select count(r)
            from Revenue r
            where r.period = :period
            and (:keyword is null or lower(r.title.value) like %:keyword%)
            and (:categoryId is null or r.categoryId.value = :categoryId)
            and (:fromDate is null or :toDate is null or (r.date >= :fromDate and r.date <= :toDate))
            and r.owner.value = ?#{principal.username}
        """
    )
    Page<Revenue> findAll(Pageable pageable,
                              @Param("period") YearMonth period,
                              @Nullable @Param("keyword") String keyword,
                              @Nullable @Param("categoryId") Long categoryId,
                              @Nullable @Param("fromDate") LocalDate fromDate,
                              @Nullable @Param("toDate") LocalDate toDate);

    @Query(
        """
            select r
            from Revenue r
            where r.period = ?1
            and r.repeatInNextPeriod
            and r.owner.value = ?#{principal.username}
        """
    )
    List<Revenue> findRepeatable(YearMonth period);

    @Query(
        """
            select new pl.wsikora.successbudget.v3.common.type.money.Money(
                r.money.currency,
                sum(r.money.value)
            )
            from Revenue r
            where r.period = ?1
            and r.owner.value = ?#{principal.username}
            group by r.money.currency
        """
    )
    List<Money> findAllMoney(YearMonth period);

    @Transactional
    @Modifying
    @Query(
        """
            delete
            from Revenue r
            where r.revenueId = ?1
            and r.owner.value = ?#{principal.username}
        """
    )
    void delete(Long revenueId);

}
