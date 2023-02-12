package pl.wsikora.successbudget.v3.cashflow.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowChecker;


@Service
class CashFlowCheckerImpl implements CashFlowChecker {

    private final CashFlowRepository cashFlowRepository;

    private CashFlowCheckerImpl(CashFlowRepository cashFlowRepository) {

        this.cashFlowRepository = cashFlowRepository;
    }

    @Override
    public boolean hasCashFlow(Long cashFlowId) {

        return cashFlowRepository.hasCashFlow(cashFlowId);
    }

}
