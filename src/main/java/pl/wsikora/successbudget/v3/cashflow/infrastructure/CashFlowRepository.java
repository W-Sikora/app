package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wsikora.successbudget.v3.cashflow.domain.CashFlow;


interface CashFlowRepository extends JpaRepository<CashFlow, Long> {

    CashFlow getByCashFlowId(Long cashFlowId);

    @Query("select count(c) > 0 from CashFlow c where c.cashFlowId = ?1 and c.owner.value = ?2")
    boolean existsByCashFlowIdAndUsername(Long cashFlowId, String username);
}
