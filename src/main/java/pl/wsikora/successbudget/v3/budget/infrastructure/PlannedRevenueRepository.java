package pl.wsikora.successbudget.v3.budget.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.budget.domain.PlannedRevenue;


@Repository
interface PlannedRevenueRepository extends JpaRepository<PlannedRevenue, Long> {

    @Modifying
    @Query("""
        delete
        from PlannedRevenue r
        where r.plannedRevenueId = ?1
        and r.owner.value = ?#{principal.username}
    """)
    void deleteByPlannedRevenueId(Long plannedRevenueId);

}
