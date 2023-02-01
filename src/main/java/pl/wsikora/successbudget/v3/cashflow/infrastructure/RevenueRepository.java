package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wsikora.successbudget.v3.cashflow.domain.Revenue;


interface RevenueRepository extends JpaRepository<Revenue, Long> {

    Revenue getByRevenueId(Long revenueId);

    @Query("select count(r) > 0 from Revenue r where r.revenueId = ?1 and r.owner.value = ?2")
    boolean existsByRevenueIdAndUsername(Long revenueId, String username);
}
