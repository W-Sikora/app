package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wsikora.successbudget.v3.cashflow.domain.CashFlow;

import java.util.Optional;


interface CashFlowRepository extends JpaRepository<CashFlow, Long> {

    @Query(
        """
            select c
            from CashFlow c
            where c.cashFlowId = ?1
            and c.owner.value = ?#{principal.username}
        """
    )
    Optional<CashFlow> findByCashFlowId(Long cashFlowId);

    @Query(
        """
            select count(c) = 1
            from CashFlow c
            where c.cashFlowId = ?1
            and c.owner.value = ?#{principal.username}
        """
    )
    boolean hasCashFlow(Long cashFlowId);

}
