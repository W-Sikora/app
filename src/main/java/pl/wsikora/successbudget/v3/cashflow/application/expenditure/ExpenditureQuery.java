package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

import org.springframework.data.domain.Page;
import pl.wsikora.successbudget.v3.cashflow.application.cashflow.CashFlowFilter;

import java.util.Optional;


public interface ExpenditureQuery {

    Optional<ExpenditureDto> findByExpenditureId(Long expenditureId);

    Page<ExpenditureDto> findAll(CashFlowFilter cashFlowFilter);

}
