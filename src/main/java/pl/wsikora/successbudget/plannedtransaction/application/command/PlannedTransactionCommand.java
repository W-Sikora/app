package pl.wsikora.successbudget.plannedtransaction.application.command;

import pl.wsikora.successbudget.plannedtransaction.domain.PlannedTransaction;


public interface PlannedTransactionCommand {

    void save(PlannedTransaction plannedTransaction);

    void delete(long id);
}
