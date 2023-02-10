package pl.wsikora.successbudget.v3.objective.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.common.type.money.Money;
import pl.wsikora.successbudget.v3.objective.domain.RaisedMoney;

import java.util.List;
import java.util.Optional;


@Repository
interface RaisedMoneyRepository extends JpaRepository<RaisedMoney, Long> {

    @Query("""
        select r
        from RaisedMoney r
        where r.raisedMoneyId = ?1
        and r.owner.value = ?#{principal.username}
    """)
    Optional<RaisedMoney> findByRaisedMoneyId(Long raisedMoneyId);

    @Query(
        value = """
            select r
            from RaisedMoney r
            where r.objective.objectiveId = ?1
            and r.owner.value = ?#{principal.username}
            order by r.date
        """,
        countQuery = """
            select count (r)
            from RaisedMoney r
            where r.objective.objectiveId = ?1
            and r.owner.value = ?#{principal.username}
        """
    )
    Page<RaisedMoney> findAll(Pageable pageable, Long objectiveId);

    @Query("""
        select r.money.currency, sum(r.money.value)
        from RaisedMoney r
        where r.objective.objectiveId = ?1
        and r.owner.value = ?#{principal.username}
        group by r.money.currency
        
    """)
    List<Money> findAllMoney(Long objectiveId);

}
