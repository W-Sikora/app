package pl.wsikora.successbudget.plannedtransaction.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractCommand;
import pl.wsikora.successbudget.plannedtransaction.application.command.PlannedTransactionCommand;
import pl.wsikora.successbudget.plannedtransaction.domain.PlannedTransaction;

@Service
class HibernatePlannedTransactionCommand extends AbstractCommand<PlannedTransaction> implements PlannedTransactionCommand {

    @Override
    protected Class<PlannedTransaction> entityClass() {

        return PlannedTransaction.class;
    }
}
