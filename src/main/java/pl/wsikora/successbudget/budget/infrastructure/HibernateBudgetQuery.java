package pl.wsikora.successbudget.budget.infrastructure;

import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractQuery;
import pl.wsikora.successbudget.budget.application.query.BudgetQuery;
import pl.wsikora.successbudget.budget.domain.Budget;

@Service
class HibernateBudgetQuery extends AbstractQuery<Budget> implements BudgetQuery {

    @Override
    protected Class<Budget> entityClass() {

        return Budget.class;
    }
}
