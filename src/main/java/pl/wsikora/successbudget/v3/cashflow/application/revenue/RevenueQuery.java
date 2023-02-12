package pl.wsikora.successbudget.v3.cashflow.application.revenue;

import java.util.Optional;


public interface RevenueQuery {

    Optional<RevenueDto> findByRevenueId(Long revenueId);

}
