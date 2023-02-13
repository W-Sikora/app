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
import java.time.YearMonth;
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
            where e.period = :period
            and (:keyword is null or lower(e.title.value) like %:keyword%)
            and (:categoryId is null or e.categoryId.value = :categoryId)
            and (:fromDate is null or :toDate is null or (e.date >= :fromDate and e.date <= :toDate))
            and e.owner.value = ?#{principal.username}
            order by e.date desc, e.money.value desc, e.priority desc
        """,
        countQuery = """
            select count(e)
            from Expenditure e
            where e.period = :period
            and (:keyword is null or lower(e.title.value) like %:keyword%)
            and (:categoryId is null or e.categoryId.value = :categoryId)
            and (:fromDate is null or :toDate is null or (e.date >= :fromDate and e.date <= :toDate))
            and e.owner.value = ?#{principal.username}
        """
    )
    Page<Expenditure> findAll(Pageable pageable,
                              @Param("period") YearMonth period,
                              @Nullable @Param("keyword") String keyword,
                              @Nullable @Param("categoryId") Long categoryId,
                              @Nullable @Param("fromDate") LocalDate fromDate,
                              @Nullable @Param("toDate") LocalDate toDate);

    @Query(
        value = """
            select e
            from Expenditure e
            where e.period = ?1
            and (e.priority = pl.wsikora.successbudget.v3.common.type.priority.Priority.UNNECESSARY
            or e.priority = pl.wsikora.successbudget.v3.common.type.priority.Priority.LOW)
            and e.owner.value = ?#{principal.username}
            order by e.date desc, e.money.value desc, e.priority desc
        """,
        countQuery = """
            select count(e)
            from Expenditure e
            where e.period = ?1
            and (e.priority = pl.wsikora.successbudget.v3.common.type.priority.Priority.UNNECESSARY
            or e.priority = pl.wsikora.successbudget.v3.common.type.priority.Priority.LOW)
            and e.owner.value = ?#{principal.username}
        """
    )
    Page<Expenditure> findAllUnnecessary(Pageable pageable, YearMonth period);

    @Query(
        """
            select e
            from Expenditure e
            where e.period = ?1
            and e.repeatInNextPeriod
            and e.owner.value = ?#{principal.username}
        """
    )
    List<Expenditure> findRepeatable(YearMonth period);

    @Query(
        """
            select new pl.wsikora.successbudget.v3.common.type.money.Money(
                e.money.currency,
                sum(e.money.value)
            )
            from Expenditure e
            where e.period = ?1
            and e.owner.value = ?#{principal.username}
            group by e.money.currency
        """
    )
    List<Money> findAllMoney(YearMonth period);

    @Transactional
    @Modifying
    @Query(
        """
            delete
            from Expenditure e
            where e.expenditureId = ?1
            and e.owner.value = ?#{principal.username}
        """
    )
    void delete(Long expenditureId);

}
