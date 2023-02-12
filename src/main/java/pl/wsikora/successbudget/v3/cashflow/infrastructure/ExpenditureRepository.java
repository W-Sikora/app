package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import pl.wsikora.successbudget.v3.cashflow.domain.Expenditure;
import pl.wsikora.successbudget.v3.common.type.money.Money;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    @Query("""
        select e
        from Expenditure e
        where e.expenditureId = ?1
        and e.owner.value = ?#{principal.username}
    """)
    Optional<Expenditure> findByExpenditureId(Long expenditureId);

    @Query(
        value = """
            select e
            from Expenditure e
            where e.cashFlow.cashFlowId = :cashFlowId
            and (:keyword is null or lower(e.title.value) like %:keyword%)
            and (:categoryId is null or e.categoryId.value = :categoryId)
            and (:fromDate is null or :toDate is null or (e.date >= :fromDate and e.date <= :toDate))
            and e.owner.value = ?#{principal.username}
            order by e.date desc, e.money.value desc, e.priority desc
        """,
        countQuery = """
            select count(e)
            from Expenditure e
            where e.cashFlow.cashFlowId = :cashFlowId
            and (:keyword is null or lower(e.title.value) like %:keyword%)
            and (:categoryId is null or e.categoryId.value = :categoryId)
            and (:fromDate is null or :toDate is null or (e.date >= :fromDate and e.date <= :toDate))
            and e.owner.value = ?#{principal.username}
        """
    )
    Page<Expenditure> findAll(Pageable pageable,
                              @Param("cashFlowId") Long cashFlowId,
                              @Nullable @Param("keyword") String keyword,
                              @Nullable @Param("categoryId") Long categoryId,
                              @Nullable @Param("fromDate") LocalDate fromDate,
                              @Nullable @Param("toDate") LocalDate toDate);

    @Query(
        """
            select e
            from Expenditure e
            where e.cashFlow.cashFlowId = ?1
            and e.repeatInNextPeriod
            and e.owner.value = ?#{principal.username}
        """
    )
    List<Expenditure> findAllRepeated(Long cashFlowId);

    @Query(
        """
            select count(e) > 0
            from Expenditure e
            where e.cashFlow.cashFlowId = ?1
            and e.repeatInNextPeriod
            and e.owner.value = ?#{principal.username}
        """
    )
    boolean hasRepeatableByCashFlowId(Long cashFlowId);

    @Query(
        """
            select new pl.wsikora.successbudget.v3.common.type.money.Money(
                e.money.currency,
                sum(e.money.value)
            )
            from Expenditure e
            where e.cashFlow.cashFlowId = ?1
            and e.owner.value = ?#{principal.username}
            group by e.money.currency
        """
    )
    List<Money> findAllMoney(Long cashFlowId);

    @Transactional
    @Modifying
    @Query(
        """
            delete
            from Expenditure e
            where e.cashFlow.cashFlowId = ?1
            and e.expenditureId = ?2
            and e.owner.value = ?#{principal.username}
        """
    )
    void delete(Long cashFlowId, Long expenditureId);

}
