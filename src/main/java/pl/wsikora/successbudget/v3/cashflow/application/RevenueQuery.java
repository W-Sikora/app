package pl.wsikora.successbudget.v3.cashflow.application;

import java.util.Optional;


public interface RevenueQuery {

    Optional<RevenueDto> findByRevenueId(Long RevenueId);

}
