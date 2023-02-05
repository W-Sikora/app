package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.budget.domain.PlannedExpenditure;


@Repository
interface PlannedExpenditureRepository extends JpaRepository<PlannedExpenditure, Long> {

    @Modifying
    @Query("""
        delete
        from PlannedExpenditure e
        where e.plannedExpenditureId = ?1
        and e.owner.value = ?#{principal.username}
    """)
    void deleteByPlannedExpenditureId(Long plannedExpenditureId);

}
