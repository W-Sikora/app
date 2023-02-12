package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.wsikora.successbudget.v3.cashflow.domain.Expenditure;
import pl.wsikora.successbudget.v3.common.type.money.Money;

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
            where e.cashFlow.cashFlowId = ?1
            and e.owner.value = ?#{principal.username}
            order by e.date desc, e.money.value desc, e.priority desc
        """,
        countQuery = """
            select count(e)
            from Expenditure e
            where e.cashFlow.cashFlowId = ?1
            and e.owner.value = ?#{principal.username}
        """
    )
    Page<Expenditure> findAll(Pageable pageable, Long cashFlowId);

    @Query(
        value = """
            select e
            from Expenditure e
            where e.cashFlow.cashFlowId = ?1
            and lower(e.title.value) like %?1%
            and e.owner.value = ?#{principal.username}
            order by e.date desc, e.money.value desc, e.priority desc
        """,
        countQuery = """
            select count(e)
            from Expenditure e
            where e.cashFlow.cashFlowId = ?1
            and lower(e.title.value) like %?2%
            and e.owner.value = ?#{principal.username}
        """
    )
    Page<Expenditure> findAllByKeyword(Pageable pageable, Long cashFlowId, String keyword);

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
            where e.expenditureId = ?1
            and e.owner.value = ?#{principal.username}
        """
    )
    void delete(Long expenditureId);

}
