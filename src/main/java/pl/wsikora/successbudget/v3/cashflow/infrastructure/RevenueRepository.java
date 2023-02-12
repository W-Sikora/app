package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.wsikora.successbudget.v3.cashflow.domain.Revenue;
import pl.wsikora.successbudget.v3.common.type.money.Money;

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
            where r.cashFlow.cashFlowId = ?1
            and r.owner.value = ?#{principal.username}
            order by r.date desc, r.money.value desc
        """,
        countQuery = """
            select count(r)
            from Revenue r
            where r.cashFlow.cashFlowId = ?1
            and r.owner.value = ?#{principal.username}
        """
    )
    Page<Revenue> findAll(Pageable pageable, Long cashFlowId);

    @Query(
        value = """
            select r
            from Revenue r
            where r.cashFlow.cashFlowId = ?1
            and lower(r.title.value) like %?1%
            and r.owner.value = ?#{principal.username}
            order by r.date desc, r.money.value
        """,
        countQuery = """
            select count(r)
            from Revenue r
            where r.cashFlow.cashFlowId = ?1
            and lower(r.title.value) like %?2%
            and r.owner.value = ?#{principal.username}
        """
    )
    Page<Revenue> findAllByKeyword(Pageable pageable, Long cashFlowId, String keyword);

    @Query(
        """
            select r
            from Revenue r
            where r.cashFlow.cashFlowId = ?1
            and r.repeatInNextPeriod
            and r.owner.value = ?#{principal.username}
        """
    )
    List<Revenue> findAllRepeated(Long cashFlowId);

    @Query(
        """
            select count(r) > 0
            from Revenue r
            where r.cashFlow.cashFlowId = ?1
            and r.repeatInNextPeriod
            and r.owner.value = ?#{principal.username}
        """
    )
    boolean hasRepeatableByCashFlowId(Long cashFlowId);

    @Query(
        """
            select new pl.wsikora.successbudget.v3.common.type.money.Money(
                r.money.currency,
                sum(r.money.value)
            )
            from Revenue r
            where r.cashFlow.cashFlowId = ?1
            and r.owner.value = ?#{principal.username}
            group by r.money.currency
        """
    )
    List<Money> findAllMoney(Long cashFlowId);

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
