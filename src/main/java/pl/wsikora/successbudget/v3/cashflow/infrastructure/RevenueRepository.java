package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wsikora.successbudget.v3.cashflow.domain.Revenue;

import java.util.Optional;


interface RevenueRepository extends JpaRepository<Revenue, Long> {

    @Query("""
        select r
        from Revenue r
        where r.revenueId = ?1
        and r.owner.value = ?#{principal.username}
    """)
    Optional<Revenue> findByRevenueId(Long revenueId);

}
