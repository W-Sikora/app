package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueDto;
import pl.wsikora.successbudget.v3.cashflow.application.revenue.RevenueQuery;

import java.util.Optional;


@Service
class RevenueQueryImpl implements RevenueQuery {

    private final RevenueRepository revenueRepository;

    RevenueQueryImpl(RevenueRepository revenueRepository) {

        this.revenueRepository = revenueRepository;
    }

    @Override
    public Optional<RevenueDto> findByRevenueId(Long revenueId) {

        return Optional.empty();
    }
}
