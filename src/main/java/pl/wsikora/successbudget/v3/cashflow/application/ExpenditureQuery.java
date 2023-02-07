package pl.wsikora.successbudget.v3.cashflow.application;

import java.util.Optional;


public interface ExpenditureQuery {

    Optional<ExpenditureDto> findByExpenditureId(Long expenditureId);

}
