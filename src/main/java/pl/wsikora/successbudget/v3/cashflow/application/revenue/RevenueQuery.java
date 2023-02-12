package pl.wsikora.successbudget.v3.cashflow.application.revenue;

import org.springframework.data.domain.Page;
import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowFilter;

import java.util.Optional;


public interface RevenueQuery {

    Optional<RevenueDto> findByRevenueId(Long revenueId);

    Page<RevenueDto> findAll(CashFlowFilter cashFlowFilter);

}
