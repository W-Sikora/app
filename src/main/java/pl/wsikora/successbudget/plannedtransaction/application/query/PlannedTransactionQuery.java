package pl.wsikora.successbudget.plannedtransaction.application.query;


import pl.wsikora.successbudget.plannedtransaction.domain.PlannedTransaction;

public interface PlannedTransactionQuery {

    PlannedTransaction getById(Long id);

}
