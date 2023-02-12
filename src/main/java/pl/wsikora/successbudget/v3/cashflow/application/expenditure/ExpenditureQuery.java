package pl.wsikora.successbudget.v3.cashflow.application.expenditure;

import java.util.Optional;


public interface ExpenditureQuery {

    Optional<ExpenditureDto> findByExpenditureId(Long expenditureId);

}
