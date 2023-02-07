package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wsikora.successbudget.v3.cashflow.domain.Expenditure;

import java.util.Optional;


interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    @Query("""
        select e
        from Expenditure e
        where e.expenditureId = ?1
        and e.owner.value = ?#{principal.username}
    """)
    Optional<Expenditure> findByExpenditureId(Long expenditureId);

    Expenditure getByExpenditureId(Long expenditureId);

    @Query("select count(e) > 0 from Expenditure e where e.expenditureId = ?1 and e.owner.value = ?2")
    boolean existsByExpenditureIdAndUsername(Long categoryId, String username);

}
