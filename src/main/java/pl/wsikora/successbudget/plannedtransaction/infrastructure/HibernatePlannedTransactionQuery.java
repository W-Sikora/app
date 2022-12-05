package pl.wsikora.successbudget.plannedtransaction.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractQuery;
import pl.wsikora.successbudget.plannedtransaction.application.query.PlannedTransactionQuery;
import pl.wsikora.successbudget.plannedtransaction.domain.PlannedTransaction;

@Service
class HibernatePlannedTransactionQuery extends AbstractQuery<PlannedTransaction> implements PlannedTransactionQuery {

    @Override
    protected Class<PlannedTransaction> entityClass() {

        return PlannedTransaction.class;
    }
}
